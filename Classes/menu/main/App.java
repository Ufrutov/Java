package main;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Scanner in = new Scanner(System.in);
		
		List<Class<?>> list = ClassFinder.find("data");

		while( true ) {
			System.out.println("Menu [Select category]:\n1: Drink\n2: Food");
			if( Calc.enable )
				System.out.println("3: Bill, please!");
			byte input = in.nextByte();
			switch ( input ) {
				case 1:
				case 2:
					String category = (input==1) ? "drink" : "food";
					System.out.println("Select item from "+category+" category:");
					list = ClassFinder.find(category);
					
					Iterator<Class<?>> index = list.iterator();
					int i = 0;
					while(index.hasNext()) {
						i++;
						Util.print(index.next(), i);
					}
					
					input = in.nextByte();
					if( input > list.size() ) {
						System.out.println("[!] Wrong input, try again.");
						break;
					}
					Util.print(list.get(input-1), 0);
					System.out.println("Select product ammount:");
					byte count = in.nextByte();
					Calc.collect(list.get(input-1), count);
					
					break;
				case 3:
					if( Calc.enable )
						Calc.showTotal();
					else
						System.out.println("[!] Wrong input, try again.");
					break;
				default:
					System.out.println("[!] Wrong input, try again.");
					break;
			}
		}
//		in.close();
	}

}
