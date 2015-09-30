
public class ArrayHomework {

	public static void main(String[] args) {
		byte array[] = {10, 11, 12, -13, 14, -15, 16, 17, 18, -19, 20, -21, 22, -23, 24, -25, 26, 27, -28, -29};
		byte above = 0;
		byte less = 0;
		
		byte i;
		
		System.out.println("Original array:");
		System.out.print("[ ");
		
		for ( i=0; i<array.length; i++ ) {
			System.out.print(array[i]+" ");
			if( array[i] > 0 )
				above++;
			else
				less++;
		}
		
		System.out.print("]\n");
		
		byte arr_above[] = new byte[above];
		byte arr_less[] = new byte[less];
		
		above = 0;
		less = 0;
		
		for ( i=0; i<array.length; i++ ) {
			if( array[i] > 0 ) {
				arr_above[above] = array[i];
				above++;
			} else {
				arr_less[less] = array[i];
				less++;
			}
		}
		
		System.out.println("Array with above zero values:");
		System.out.print("[ ");
		for ( i=0; i<arr_above.length; i++ ) {
			System.out.print(arr_above[i]+" ");
		}
		System.out.print("]\n");
		
		System.out.println("Array with lezz zero values:");
		System.out.print("[ ");
		for ( i=0; i<arr_less.length; i++ ) {
			System.out.print(arr_less[i]+" ");
		}
		System.out.print("]\n");
		
	}

}
