import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		byte var1;
		byte var2;
		
		System.out.println("Enter fist:");
		var1 = scanner.nextByte();
		System.out.println("Enter second:");
		var2 = scanner.nextByte();
		
		if( var1 != var2 )
			while( var1 != var2 ) {
				System.out.print(var1+" ");
				var1 += ( var1 < var2 ) ? 1 : -1;
			}
		else
			System.out.println("Equal values!");
		
		scanner.close();
	}

}
