package menu;

import citckhen.Drink;

public class Cola extends Drink {
	public static String name = "Coca Cola";
	public static float quantity = 330.00f;
	public static float price = 20.00f;
	
	public static void info () {
		print("[Drink]");
		print("Name: "+name);
		print("Vol.: "+quantity+" "+unit);
		print("Price: "+price);
	}
}
