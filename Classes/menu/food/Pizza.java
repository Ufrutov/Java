package food;

import data.Food;

public class Pizza extends Food {
	
	public static String name = "Pizza";
	public static String unit = "item";
	public static float vol = 450.00f;
	public static float price = 65.00f;
	
	public static void dishInfo() {
		System.out.printf("%s: %s of %.2f%s, %.2f mdl\n", name, unit, vol, m, price);
	}
	
}
