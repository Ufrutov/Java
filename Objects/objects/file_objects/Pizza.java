package file_objects;

public class Pizza {
	public static String brand = "Andys Pizza";
	
	public String name;
	public String contains;
	public float price;
	
	public Pizza(String n, String c, float p) {
		name = n;
		contains = c;
		price = p;
	}
	
	public void info() {
		System.out.printf("Pizza: %s (%s)\nComposition: %s\nPrice: %.2f mdl\n", name, brand, contains, price);
	}
}
