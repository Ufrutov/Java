import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Query.start();
		
		while(true) {
			System.out.println("\n(1) Create new student;\n"
					+ "(2) List all students;\n"
					+ "(3) Delete student by id;\n"
					+ "(x) Exit;\n"
					+ "-------------------------------------");
			
			Scanner in = new Scanner(System.in);
			
			switch( in.nextLine() ) {
				case "1":
					System.out.println("New strudent");
					Student person = new Student();
					Query.insert(person);
					break;
				case "2":
					System.out.println("[L] List all db items:");
					Query.list();
					break;
				case "3":
					System.out.println("[D] Delete row by id:");
					int id = in.nextInt();
					Query.delete(id);
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
