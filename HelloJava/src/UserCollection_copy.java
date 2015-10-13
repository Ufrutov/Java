import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UserCollection_copy {

	public static void main(String[] args) {
		// Collection of users: key - name
		// Params: [0]phone, [1]year, [2]id
		Map<String, Map<String, String>> people = new LinkedHashMap<String, Map<String, String>>();
		Map<String, String> user = new HashMap<String, String>();
		
		Scanner in = new Scanner(System.in);
		
		while(true) {
			System.out.println("Enter new users name [Exit: 0]:");
			String name = in.nextLine();
			if( name.equals("0") ) {
				System.out.println("Stopped");
				break; }
			
			System.out.println("Enter users id:");
			String input = in.nextLine();
			user.put("id", input);
			
			System.out.println("Enter users birth year:");
			input = in.nextLine();
			user.put("year", input);
			
			System.out.println("Enter users phone number:");
			input = in.nextLine();
			user.put("phone", input);
			
//			Add user
			people.put(name, user);
			
			user = new HashMap<String, String>();
		}
		
		people.put("John Dee", new HashMap<String, String>(){{ 
			put("id", "1");
			put("year", "1987");
			put("phone", "546665415123");
		}});
		people.put("Stve Jobs", new HashMap<String, String>(){{ 
			put("id", "2");
			put("year", "1965");
			put("phone", "5687745513132");
		}});
		people.put("Hele Hurper", new HashMap<String, String>(){{ 
			put("id", "3");
			put("year", "1985");
			put("phone", "45687664354135");
		}});
		
//		Get keys of Map object
		
		Set<String> keys = people.keySet();
		Iterator<String> index = keys.iterator();

		System.out.println("Result array:");
		while(index.hasNext()) {
			String i = index.next();
			System.out.print(i+" >\t");
			System.out.print("id: "+people.get(i).get("id")+"\t");
			System.out.print("year: "+people.get(i).get("year")+"\t");
			System.out.print("phone: "+people.get(i).get("phone"));
			System.out.print("\n");
		}
		
	}

}
