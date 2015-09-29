import java.util.Arrays;


public class ArrayTemp {

	public static void main(String[] args) {
		float[] temp = {-10.5f, -9.0f, 5.0f, 15.0f, 25.5f, 6.0f, 0.0f };
		float[] temp2 = {10.5f, -9.0f, 5.0f, 15.0f, 25.5f, 6.0f, 0.0f };
		
		Arrays.sort(temp);
		
		System.out.println( Arrays.equals(temp, temp2) );
		System.out.println( Arrays.binarySearch(temp, 15.0f) );
		
		float[] temp3 = Arrays.copyOfRange(temp, 0, 5);
		
		int day;
		float total = 0;
		float minus = 0;
		for( day = 0; day<temp.length; day++ ) {
			System.out.print(temp[day]+" | ");
			total+=temp[day];
			if( minus > temp[day] )
				minus = temp[day];
			
		}
		System.out.print("\n");
		for( day = 0; day<temp3.length; day++ ) {
			System.out.print(temp3[day]+" | ");	
		}
		
		float avg = total/temp.length;
		
		System.out.printf("\nAvg. Temp is %.2f C\n", avg);
		System.out.printf("Abs. Minus is %.2f C\n", minus);
	}

}
