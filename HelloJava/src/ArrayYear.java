
public class ArrayYear {

	public static void main(String[] args) {
		short[] buget = { 125, 1000, 500, 540, 200, 500, 600, 650, -100, 0, 150, -500 };
		
//		Year budget - 12
//		Check if there is more than 200
		
		byte i;
		
		for( i = 0; i < buget.length; i++ ) {
			if( buget[i] > 200 )
				System.out.printf("[%d]\t %d\n", i, buget[i]);
		}
	}
}
