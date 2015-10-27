package file_objects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Locale;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws IOException {
		System.out.println("** File Objects App ***");
		
		Boolean loop = true;
		while(loop) {
			System.out.printf("\nSelect action:\n1: Print objects list;\n2: Add new object;\n3: Exit;\n");
			Scanner in = new Scanner(System.in);
			byte input = in.nextByte();
			switch(input) {
				case 1:
					ArrayList<Object> list = Util.printList();
					System.out.printf("\nActions:\n1: Select item to view info;\n2: Delete item;\n");
					byte item = in.nextByte();
					switch(item) {
						case 1:
							System.out.println("Select item:");
							byte i = in.nextByte();
							Util.printInfo(i, list);
							break;
						case 2:
							System.out.println("Magic! It will delete any item!");
							break;
						default:
							System.out.println("[!] Wrong input");
							break;
					}
					
					break;
				case 2:
					StringBuilder sb = new StringBuilder();
					Formatter formatter = new Formatter(sb, Locale.US);
					
					System.out.println("Add new item to Pizza list");
					
					Scanner inp = new Scanner(System.in);
					
					System.out.println("Input Pizza name:");
					String name = inp.nextLine();
					
					System.out.println("Input Pizza composition:");
					String contains = inp.nextLine();
					
					System.out.println("Input new item price:");
					String price = inp.nextLine();
					
					String newLine = formatter.format("name: %s; contains: %s; price: %s;", name, contains, price).toString();
					System.out.printf("New item: name: %s; contains: %s; price: %s mdl;\n", name, contains, price);
					
					Util.addNew(newLine);
					break;
				case 3:
					loop = false;
					break;
				default:
					System.out.println("[!] Wrong input");
			}
		}
	}
}
