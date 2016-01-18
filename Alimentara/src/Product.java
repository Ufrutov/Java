import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Product {
	public String name;
	public String desc;
	public float price;
	public Date expdate;
	
	Product() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter new product name:");
		this.name = in.nextLine();

		System.out.println("Enter new product description:");
		this.desc = in.nextLine();

		System.out.println("Enter new product price:");
		this.price = Float.valueOf(in.nextLine());

		System.out.println("Enter new product expiration date (dd.mm.yy) :");
		Date expdate = this.parseDate(in.nextLine(), "d.m.y");
		this.expdate = expdate;
		
		in.close();
	}
	
	public Date parseDate(String date, String format) {
	    try {
	    	SimpleDateFormat formatter = new SimpleDateFormat(format);
			return formatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return new Date();
		}
	}
	
	public static String formatDate(String date, String format){
		String output;
		Date expdate = new Date();
		
		SimpleDateFormat input = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
		try {
			expdate = input.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		output = formatter.format(expdate);
		return output;
	} 
}
