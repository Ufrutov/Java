
public class App_src {

	public static void main(String[] args) {
		// Create objects of Class Juice
		Juice obj1 = new Juice(0.5f, 10.0f);
		Juice obj2 = new Juice(1.5f, 25.0f);
		Juice obj3 = new Juice(2.5f, 40.0f);
		
		System.out.println("Juice 1: "+obj1.brand+", "+obj1.madein+", "+obj1.volume+", "+obj1.price);
		System.out.println("Juice 1: "+obj2.brand+", "+obj2.madein+", "+obj2.volume+", "+obj2.price);
		System.out.println("Juice 3: "+obj3.brand+", "+obj3.madein+", "+obj3.volume+", "+obj3.price);
	}

}
