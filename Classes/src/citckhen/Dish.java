package citckhen;

import java.util.Scanner;

public class Dish {
	
	public static float price = 0.00f;
	public static String name = "Dish";
	public static float quantity = 0.00f;
	public static String unit = "";
	
	public static short amount = 0;
	
	public static void print (String text) {
		System.out.println( text );
	}
	
	public static void info () {
		print("Unknown");
	}
	
	public static void order() {
		print("---Order---");
		print("Amount?");
		Scanner input = new Scanner(System.in);
		amount = input.nextShort();
		
		input.close();
	}
	
}
