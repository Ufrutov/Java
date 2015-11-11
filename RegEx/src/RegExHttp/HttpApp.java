package RegExHttp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpApp {

	public static void main(String[] args) {
		String content = "";
		try {
//			URL address = new URL("https://www.tumblr.com/");
			URL address = new URL("http://unimedia.info/");
			BufferedReader in = new BufferedReader( new InputStreamReader( address.openStream() ) );
			
			while(true) {
				String line = in.readLine();
				content += line;
				if( line == null ) break;
			}
			
//			String reg = "([<](/)?img[^>]*[>])";
			String reg = "<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>";
			
			Pattern ptrn = Pattern.compile(reg);
			
			Matcher m = ptrn.matcher(content);
			
			ArrayList<String> list = new ArrayList<String>();
						
			while( m.find() ) {
				list.add(m.group(1));
			}
			
			Iterator index = list.iterator();
			
			String dir = null;
			if(list.size() != 0)
				dir = Util.makeDir();
			
			int count = 1;
			int saved = 0;
			int failed = 0;
			while( index.hasNext() ) {
				if(Util.saveImg(index.next().toString(), dir, String.valueOf(count++), list.size()))
					saved++;
				else
					failed++;
			}
			
			System.out.println("------------------------------------------------");
			System.out.println("Working folder: "+dir);
			System.out.println("Found images: "+list.size());
			System.out.println("Success saved: "+saved);
			System.out.println("Error picture format: "+failed);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
