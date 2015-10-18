package drink;

import data.Drink;

public class Cofe extends Drink {
	
	public static String name = "Arabic Coffe";
	public static String unit = "cup";
	public static float vol = 50.00f;
	public static float price = 15.00f;
	
	public static void dishInfo() {
		System.out.printf("%s: %s of %.2f%s, %.2f mdl\n", name, unit, vol, m, price);
	}
}
