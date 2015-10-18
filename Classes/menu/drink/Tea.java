package drink;

import data.Drink;

public class Tea  extends Drink {
	
	public static String name = "Black Tea";
	public static String unit = "cup";
	public static float vol = 100.00f;
	public static float price = 5.00f;
	
	public static void dishInfo() {
		System.out.printf("%s: %s of %.2f%s, %.2f mdl\n", name, unit, vol, m, price);
	}
}
