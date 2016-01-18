import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Query.start();
		
		while(true) {
			System.out.println("\n(1) Add new product;\n"
					+ "(2) List all products;\n"
					+ "(3) Update product;\n"
					+ "(4) Delete product by id;\n"
					+ "(x) Exit;\n"
					+ "-------------------------------------");
			
			Scanner in = new Scanner(System.in);
			
			switch( in.nextLine() ) {
				case "1":
					System.out.println("New product:");
					Product product = new Product();
					Query.insert(product);
					break;
				case "2":
					System.out.println("[L] List all products:");
					Query.list(0);
					break;
				case "3":
					System.out.println("[U] Enter product id:");
					int update = in.nextInt();
					Query.update(update);
					break;
				case "4":
					System.out.println("[D] Delete product by id:");
					int id = in.nextInt();
//					Query.delete(id);
					break;
				case "x":
					in.close();
					Query.stop();
					return;
				default:
					System.out.println("[E] Error input, try again.");
			}		
		}
	}
}
