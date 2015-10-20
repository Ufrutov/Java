
public class Pizza {
	
	public static String brand = "Chelentano";
	public static String madein = "Moldova";
	
	public String name;
	public float massa;
	public float price;
	
	public Pizza (String n, float m, float p) {
		name = n;
		massa = m;
		price = p;
	}
	
	public Pizza() {
		// TODO Auto-generated constructor stub
	}

	public void pizza_info () {
		System.out.printf("%s: %s - %s, %.2fg, %.2f mdl \n", name, brand, madein, massa, price);
	}
	
}
