package collections;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayList_ex {

	public static void main(String[] args) {
		
		ArrayList<Float> prices = new ArrayList<Float>();
		
		Iterator<Float> itr;
		
		prices.add(100F);
		prices.add(200F);
		prices.add(300F);
		prices.add(400F);
		
		itr = prices.iterator();
		
		for( ; itr.hasNext(); ) {
			System.out.println(itr.next()+" <<");
		}
		
		while( itr.hasNext() ) {
			System.out.println(itr.next()+" ");
		}
		
//		System.out.println("Initial size: "+prices.size());
//		byte i;
//		for( i=0; i<prices.size(); i++ ) {
//			System.out.println(prices.get(i)); }
//		
//		prices.set(1, 1000F);
//		
//		System.out.println("After addition:");
//		
//		for( i=0; i<prices.size(); i++ ) {
//			System.out.println(prices.get(i)); }
//		
//		prices.remove(1);
//		
//		System.out.println("After remove:");
//		
//		for( i=0; i<prices.size(); i++ ) {
//			System.out.println(prices.get(i)); }
//		prices.iterator();

	}

}
