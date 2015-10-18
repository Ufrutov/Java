package drink;

import data.Drink;

public class Cola extends Drink {
	
	public static String name = "Coca Cola";
	public static String unit = "bottle";
	public static float vol = 330.00f;
	public static float price = 25.00f;
	
	public static void dishInfo() {
		System.out.printf("%s: %s of %.2f%s, %.2f mdl\n", name, unit, vol, m, price);
	}

}
