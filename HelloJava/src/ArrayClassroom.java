
public class ArrayClassroom {

	public static void main(String[] args) {
		// 3 Arrays retrieve values: count, order, price
		byte[] count = { 10, 5, 1 };
		byte[] order = { 8, 5, 10 };
		float[] price = { 2.5f, 10.99f, 5.0f };
		float total = 0;
		byte i;
		for( i = 0; i<count.length; i++ ) {
			if( order[i] > count[i] ) {
				System.out.println("[!] There is not "+order[i]+" products, avialable obly "+count[i]);
				order[i] = count[i];
			}
			System.out.printf( "Order %d:\t Count - %d,\t Orders - %d,\t Price - %.2f,\t Total = %.2f \n", i+1, count[i], order[i], price[i], order[i]*price[i]);
			total+=order[i]*price[i];
		}
		
		System.out.printf("Total price is: %.2f \n\n", total);
		
		for( i = 0; i<count.length; i++ ) {
			System.out.println(order[i]);
		}
		
	}

}
