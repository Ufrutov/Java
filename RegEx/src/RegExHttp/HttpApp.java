package RegExHttp;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
			
			while( index.hasNext() ) {
				System.out.println(index.next());
			}
			
			System.out.println("Array size: "+list.size());
			
			
	        
//	        D:\s_workspace\VanarJava\Java\RegEx
	        try {
	        	Calendar cal = Calendar.getInstance();
		        SimpleDateFormat sdf = new SimpleDateFormat("d_M_Y-HH_mm_ss");
		        String time = sdf.format(cal.getTime());
		        
		        File f = null;
		        
	        	f = new File("D:/s_workspace/VanarJava/Java/RegEx/assets/"+time);
	            
	            // create
	            f.mkdir();
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
