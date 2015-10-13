
public class Person {
	
//	Class properties
//	modificator [static] type name = value;
	public static String name = "John Dee";
	public static String nation = "md";
	public static byte age = 40;
	
//	Class methods
//	modificator [static] return_type name( type args ) { execution }
	
	public static void hello() {
		System.out.println("Hello, this is a Person!");
	}
	
	public static void about() {
		System.out.println("Name: "+name);
		System.out.println("Age of: "+age);
		System.out.println("Nation: "+nation);
	}
	
}
