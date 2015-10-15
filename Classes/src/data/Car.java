package data;

public class Car {
	
	public static String model = "BMW";
	public static short year = 2000;
	public static int price = 10000;
	
	public static void info() {
		print("-----------------");
		print("Car model: "+model);
		print("Model year: "+year);
		print("Model price: "+price);
	}
	
	public static void print (String text) {
		System.out.println( text );
	}
	
}
