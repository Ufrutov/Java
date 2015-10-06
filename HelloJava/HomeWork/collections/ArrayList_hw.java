package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayList_hw {

	public static void main(String[] args) {
		ArrayList<Integer> values = new ArrayList<Integer>(Arrays.asList(0, 1, -2, -3, 4, -5, -6, 7, 8, -9, 10, 11, 12, -13, 14, -15, 16, 17, 18, -19, 20, -21, 22, -23, 24, -25, 26, 27, -28, -29));
		ArrayList<Integer> great = new ArrayList<Integer>();
		ArrayList<Integer> less = new ArrayList<Integer>();
		int i;
		Iterator<Integer> itr = values.iterator();
		
		System.out.println("Original collection ["+values.size()+"]:");
		while(itr.hasNext()) {
			i = itr.next();
			System.out.print(i+" ");
			if( i >= 0 )
				great.add(i);
			else
				less.add(i);
		}
		
		itr = great.iterator();
		System.out.println("\nGreat than zero collection ["+great.size()+"]:");
		while(itr.hasNext())
			System.out.print(itr.next()+" ");
		
		itr = less.iterator();
		System.out.println("\nLess than zero collection ["+less.size()+"]:");
		while(itr.hasNext())
			System.out.print(itr.next()+" ");
		
	}

}
