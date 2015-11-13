
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Util {

	public static Boolean openStream(String url) {
		
		try {
			if( !url.contains("https://") || !url.contains("http://") )
				url = "http://"+url;
			URL address = new URL(url);
			BufferedReader in = new BufferedReader( new InputStreamReader( address.openStream() ) );			
			return true;
		} catch(Exception e) {
			System.out.println("[E] Invalid url: "+url);
			return false;
		}
	}
	
	public static String makeDir() {
		String output = null;

        try {
        	Calendar cal = Calendar.getInstance();
	        SimpleDateFormat sdf = new SimpleDateFormat("d_M_Y-HH_mm_ss");
	        String time = sdf.format(cal.getTime());
	        final String dir = System.getProperty("user.dir");
	        
	        File f = null;
	        
        	f = new File(dir+"/assets/"+time);
            
            f.mkdir();
            output = f.getAbsolutePath();
        } catch (Exception e) {
        	e.printStackTrace();
        }
       
		return output;
	}
	
	public static void getImg(Boolean running, String url, JTextPane panel, JProgressBar progress) {
		String content = "";
		try {
			if( !url.contains("https://") || !url.contains("http://") )
				url = "http://"+url;
			URL address = new URL(url);
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
			
			Iterator<String> index = list.iterator();
			
			String dir = null;
			if(list.size() != 0)
				dir = Util.makeDir();
			
			int count = 1;
			int saved = 0;
			int failed = 0;
			while( index.hasNext() ) {
				String line = index.next().toString();
				if(Util.saveImg(line, dir, String.valueOf(count++), list.size(), progress)) {
//					Util.appendText(panel, "[S] "+line, "default");
					saved++;
				} else {
//					Util.appendText(panel, "[F] "+line, "error");
					failed++;
				}
			}
			Util.appendText(panel, "-----------------------------", "success");
			Util.appendText(panel, "SUCCESS", "success");
			Util.appendText(panel, "Found "+(count-1)+" images", "default");
			Util.appendText(panel, "Downloaded "+saved+" images", "default");
			Util.appendText(panel, "Failed "+failed+" images", "default");
			Util.appendText(panel, "Saved to "+dir, "default");
			Util.appendText(panel, "-----------------------------", "default");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean saveImg(String src, String dir, String name, int size, JProgressBar progress) {
		String[] availabe = {"jpg", "png", "gif", "jpeg"};
		String[] split = src.split("\\.");
		String ext = split[split.length-1];
		
		// Percent
		System.out.print((int) Math.ceil( Integer.valueOf(name)*100/size )+"% ");
		progress.setValue((int) Math.ceil( Integer.valueOf(name)*100/size ));
		progress.update(progress.getGraphics());
		
		if( Arrays.asList(availabe).contains(ext.toLowerCase()) ) {
			
			BufferedImage image =null;
	        try{
	 
	            URL url = new URL(src);
	            image = ImageIO.read(url);

	            ImageIO.write(image, ext, new File(dir+"/"+name+"."+ext));
	            System.out.println("[Success]: Saved picture. ("+src+")");
	            return true;
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	return false;
	        }
		} else {
			System.out.println("[Error]: Wrong picture extension. ("+src+")");
			return false;
		}
	}
	
	public static void appendText(JTextPane panel, String line, String type) {
		StyledDocument doc = panel.getStyledDocument();

		//  Define a keyword attribute
		
		SimpleAttributeSet keyWord = new SimpleAttributeSet();
		
		switch(type) {
			case "error":
				StyleConstants.setForeground(keyWord, Color.RED);
				break;
			case "success":
				StyleConstants.setForeground(keyWord, Color.GREEN);
				StyleConstants.setAlignment(keyWord, StyleConstants.ALIGN_CENTER);
				break;
			default:
				StyleConstants.setForeground(keyWord, Color.BLACK);
		}
		
//		StyleConstants.setBackground(keyWord, Color.YELLOW);
//		StyleConstants.setBold(keyWord, true);
	
		//  Add some text
	
		try {
		    doc.insertString(doc.getLength(), line+"\n", keyWord );
		    panel.update(panel.getGraphics());
		} catch(Exception e) { System.out.println(e); }
	} 
}
