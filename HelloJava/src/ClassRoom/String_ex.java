package ClassRoom;

public class String_ex {

	public static void main(String[] args) {
		// Loop array with strings
		String[] country = { "Malta", "Italy", "Moldova", "USA", "Russia" };
		
		byte i = 0;
		
		while(i<country.length) {
			System.out.print(country[i]);
			if( country[i].indexOf("Moldova") != -1 )
				System.out.println(" - this my home!");
			else
				System.out.println();
			i++;
		}

	}

}
