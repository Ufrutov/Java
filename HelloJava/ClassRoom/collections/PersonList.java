package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PersonList {

	public static void main(String[] args) {
//		Collection of Strings
		ArrayList<String> people = new ArrayList<String>();
//		Scanner
		Scanner keyb = new Scanner(System.in);
		String input;
		
		do{
			System.out.println("Enter name for collection [Exit: stop]:");
			input = keyb.nextLine();
			
			if( input.equals("stop") ) {
				System.out.println("Stopped");
				break;
			} else
				people.add(input);
			
			System.out.println("Got it: "+input);
			
		}while(true);
		
		Iterator<String> itr = people.iterator();

		//	Show collection
		System.out.print("Result array: [ ");
		while( itr.hasNext() )
			System.out.print(itr.next()+" ");
		System.out.print("]\n");
		
		//	Search in collection
		while( true ){
			System.out.println("Search in collection [Exit: stop]:");
			input = keyb.nextLine();
			
			if( input.equals("stop") ) {
				System.out.println("[S] Stopped");
				break;
			} else {				
				if( people.contains(input) )
					System.out.println(input+" found at "+people.indexOf(input)+" index.");
				else
					System.out.println("[!] Not found: "+input+" is not present at the collection.");
				continue;
			}
		}
		
		//	Show collection
		itr = people.iterator();
		System.out.print("Result array: [ ");
		while( itr.hasNext() )
			System.out.print(itr.next()+" ");
		System.out.print("]\n");
		
		//	Find elements by first characters		
		while( true ){
			System.out.println("Search in collection by first characters [Exit: stop]:");
			input = keyb.nextLine();
			
			if( input.equals("stop") ) {
				System.out.println("[S] Stopped");
				break;
			} else {
				itr = people.iterator();
				while( itr.hasNext() ) {
					String value = itr.next();
					if( value.indexOf(input) == 0 )
						System.out.println(value+" found by charter "+input);
				}					
				continue;
			}
		}
		
//		Show collection
		itr = people.iterator();
		System.out.print("Result array: [ ");
		while( itr.hasNext() )
			System.out.print(itr.next()+" ");
		System.out.print("]\n");
		
//		Delete element from collection by index
		while( true ){
			System.out.println("Delete element by index [Exit: stop]:");
			input = keyb.nextLine();
			
			if( input.equals("stop") ) {
				System.out.println("[S] Stopped");
				break;
			} else {
				Integer index = Integer.parseInt(input);
				if( index > people.size() )
					System.out.println("[S] There is not such large index.");
				else {
					System.out.println("[R] Removed item "+people.get(index)+" from index "+index+".");
					people.remove(index.intValue());
					
					itr = people.iterator();
					System.out.print("\nResult array: [ ");
					while( itr.hasNext() )
						System.out.print(itr.next()+" ");
					System.out.print("]\n");
				}
			}
		}
		
		keyb.close();
	}
}
