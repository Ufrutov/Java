
public class Car {
	
	public static String brand;
	public static String source;
	private static String type;
	
	/* @return the type */
	public static String getType() {
		return type;
	}

	/* @param type the type to set */
	public static void setType(String type) {
		Car.type = type;
	}

	public static void about() {
		System.out.println("Car brand: "+brand);
		System.out.println("Car works with: "+source);
		System.out.println("Cars type: "+getType());
	}
	
}
