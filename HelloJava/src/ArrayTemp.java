
public class ArrayTemp {

	public static void main(String[] args) {
		float[] temp = {-10.5f, -9.0f, 5.0f, 15.0f, 25.5f, 6.0f, 0.0f };
		
		int day;
		float total = 0;
		float minus = 0;
		for( day = 0; day<temp.length; day++ ) {
			
			total+=temp[day];
			if( minus > temp[day] )
				minus = temp[day];
			
		}
		float avg = total/temp.length;
		
		System.out.println("Avg. Temp is "+avg);
		System.out.println("Abs. Minus is "+minus);
	}

}
