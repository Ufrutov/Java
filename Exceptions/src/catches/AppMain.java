package catches;

import java.util.Scanner;

public class AppMain {

	public static void main(String[] args) {
		System.out.println("*** Subscribe email application ***");
		Scanner in = new Scanner(System.in);
		String input;
		
		while(true) {
			System.out.println("Enter You email");
			try{
				input = in.nextLine();
				
				if( input.length() < 5 ) throw new Exception("Too short input");
				if( input.indexOf("@") == -1 ) throw new Exception("Wrong email format");
				
				System.out.println("Succesfully subscribed "+input+"!");
				break;
				
			} catch(Exception e) {
				System.out.println("[E] "+e.getMessage());
			}
		}
		while(true) {
			System.out.println("Enter You password");
			try {
				input = in.nextLine();
				if( input.length() < 5 ) throw new Exception("Too short input");
				
				System.out.println("Logged!");
				break;
				
			} catch(Exception e) {
				System.out.println("[E] "+e.getMessage());
			}
		}
		
		in.close();

	}
}
