
public class Array {

	public static void main(String[] args) {
		byte[] count = {100,5,100,40,30,1,20};
		float[] price = {10.5f, 5.75f, 3.25f, 2.77f, 4.01f, 15.78f, 0.99f};
		int i;
		float total = 0;
		for( i=0; i<count.length; i++ ) {
			System.out.println(count[i]*price[i]);
			total+=count[i]*price[i];
		}
		
		if( total>1000 ) {
			System.out.println("You got a discount 20%");
			total-=total*0.2;
		}
		System.out.println("Totla price: "+total);
	}

}
