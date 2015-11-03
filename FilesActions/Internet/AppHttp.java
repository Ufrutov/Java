import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class AppHttp {

	public static void main(String[] args) {
		
		try {
			URL address = new URL("http://torrentsmd.eu");
			
			BufferedReader in = new BufferedReader( new InputStreamReader( address.openStream() ) );
			
			int i = 0;
			while(true) { 
				String line = in.readLine();

				if( line == null )
					break;
				i++;
				System.out.println("["+i+"] "+line.length()+" : "+line);
			}
			
		} catch (Exception e) {
			System.out.println("Address not available");
			e.printStackTrace();
		}

	}

}
