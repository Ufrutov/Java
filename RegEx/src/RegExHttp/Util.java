package RegExHttp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import javax.imageio.ImageIO;

public class Util {

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
	
	public static boolean saveImg(String src, String dir, String name, int size) {
		String[] availabe = {"jpg", "png", "gif", "jpeg"};
		String[] split = src.split("\\.");
		String ext = split[split.length-1];
		
		System.out.print((int) Math.ceil( Integer.valueOf(name)*100/size )+"% ");
		
		if( Arrays.asList(availabe).contains(ext.toLowerCase()) ) {
			
			BufferedImage image =null;
	        try{
	 
	            URL url = new URL(src);
	            image = ImageIO.read(url);

	            ImageIO.write(image, ext, new File(dir+"/"+name+"."+ext));
	            System.out.println("[Success]: Saved picture. ("+src+")");
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
			
			return true;
		} else {
			System.out.println("[Error]: Wrong picture extension. ("+src+")");
			return false;
		}
	}
}
