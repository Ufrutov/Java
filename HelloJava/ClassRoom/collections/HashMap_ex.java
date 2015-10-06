package collections;

import java.util.HashMap;
import java.util.Map;

public class HashMap_ex {

	public static void main(String[] args) {
//		Declare Map in memory
		Map<String, Integer> city = new HashMap<String, Integer>();
//		Map<String, ArrayList> city = new HashMap<String, ArrayList>();
		
		city.put("Chisinau", 800000);
		city.put("Paris",    2000000);
		city.put("London",   8000000);

		System.out.println("Paris: "+city.get("Paris"));
		System.out.println("Chisinau: "+city.get("Chisinau"));
		
	}

}
