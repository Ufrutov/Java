package food;

import data.Food;

public class Soup extends Food {
	
	public static String name = "Potato Soup";
	public static String unit = "plate";
	public static float vol = 350.00f;
	public static float price = 15.00f;
	
	public static void dishInfo() {
		System.out.printf("%s: %s of %.2f%s, %.2f mdl\n", name, unit, vol, m, price);
	}
}
