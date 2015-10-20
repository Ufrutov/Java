
public class Juice {
//	Static properties are commons for all objects of Class
	public static String brand = "Orhei Vit";
	public static String madein = "Moldova";
	
//	Personal properties of Class Objects
	public float volume;
	public float price;
	
//	Class constructor
	public Juice() {
		System.out.println("New Juice is ready!");
	}
	
	public Juice( float v, float p ) {
		volume = v;
		price = p;
	}
	
}
