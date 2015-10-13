import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UserCollection {

	public static void main(String[] args) {
		// Collection of users: key - name
		// Params: [0]phone, [1]year, [2]id
		Map<String, ArrayList> people = new LinkedHashMap<String, ArrayList>();
		ArrayList<String> user = new ArrayList<String>();
		
		Scanner in = new Scanner(System.in);
		
		while(true) {
			System.out.println("Enter new users name [Exit: 0]:");
			String name = in.nextLine();
			if( name.equals("0") ) {
				System.out.println("Stopped");
				break; }
			
			System.out.println("Enter users id:");
			String input = in.nextLine();
			user.add(input);
			
			System.out.println("Enter users birth year:");
			input = in.nextLine();
			user.add(input);
			
			System.out.println("Enter users phone number:");
			input = in.nextLine();
			user.add(input);
			
//			Add user
			people.put(name, user);
			
			user = new ArrayList<String>();
		}
		
		people.put("John Dee", new ArrayList<String>(Arrays.asList("1", "1956", "123456789")));
		people.put("Stve Jobs", new ArrayList<String>(Arrays.asList("2", "1970", "123456789")));
		people.put("Hele Hurper", new ArrayList<String>(Arrays.asList("3", "1965", "123456789")));
		
//		Get keys of Map object
		
		Set<String> keys = people.keySet();
		Iterator<String> index = keys.iterator();

		System.out.println("Result array:");
		while(index.hasNext()) {
			String i = index.next();
			System.out.print(i+" >\t");
			System.out.print("id: "+people.get(i).get(0)+"\t");
			System.out.print("year: "+people.get(i).get(1)+"\t");
			System.out.print("phone: "+people.get(i).get(2));
			System.out.print("\n");
		}
		
		in.close();
		
	}

}
