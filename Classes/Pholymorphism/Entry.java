
public class Entry {
	
	public static void hello() {
		System.out.println("Hello!");
	}
	
	public static void hello( String name ) {
		System.out.println("Hello, "+name+"!");
	}
	
	public static void hello( String name, String lang ) {
		switch(lang) {
			case "ru":
				System.out.println("Привет, "+name+"!");
				break;
			default:
				System.out.println("Hello, "+name+"!");
		} 
	}
	
	public static void hello( String name, int i ) {
		int j = 1;
		while( j<=i ) {
			System.out.println("["+j+"] Hello, "+name+"!");
			j++;
		}
		
	}
	
}
