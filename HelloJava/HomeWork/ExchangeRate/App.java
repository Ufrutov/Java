package ExchangeRate;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner action = new Scanner(System.in);
		Scanner in = new Scanner(System.in);
		String input;
		
		do{
			
			System.out.println("Exchange app:");
			if( History.enable )
				System.out.println("[0] Exchange history:");
			System.out.println("[1] MDL > USD:");
			System.out.println("[2] USD > MDL:");
			
			input = action.nextLine();
			
			switch ( input ) {
				case "0":
					History.print();
					break;
				case "1":
					System.out.println("[MDL] Enter value:");
					Exchange.rate = "MDL";
					Exchange.value = in.nextFloat();
					Exchange.convert();
					break;
				case "2":
					System.out.println("[USD] Enter value:");
					Exchange.rate = "USD";
					Exchange.value = in.nextFloat();
					Exchange.convert();
					break;
				default:
					System.out.println("[!] Wrong input, please, try again;\n");
					break;
			}
		}while(true);
	}
}
