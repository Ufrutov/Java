import java.util.Scanner;

public class CountTotal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		float input = 1.0f;
		float total = 0.0f;
		
		System.out.println("Enter number [0: Exit]:");
		
		while (input != 0) {
			input = 0.0f;
			input = scanner.nextFloat();
			total += input;
		}
		
		System.out.println("Total: "+total);
		
		scanner.close();
	}

}
