import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		final short year = 2015;
		short byear;
		short age = 0;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter Your age:");
		
		try {
			age = in.nextShort();
			
//			Check if 1 < age < 150
			if( age < 1 || age > 150 ) throw new Exception("[E] Wrong age input;");
			
			byear = (short)(year-age);
			System.out.println("You were born in: "+byear);
			
			in.close();
		} catch(InputMismatchException e) {
			System.out.println("[E] Error input!");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
