package food;

import data.Food;

public class Burger extends Food {
	
	public static String name = "Chicken Burger";
	public static String unit = "burger";
	public static float vol = 250.00f;
	public static float price = 35.00f;
	
	public static void dishInfo() {
		System.out.printf("%s: %s of %.2f%s, %.2f mdl\n", name, unit, vol, m, price);
	}
}
