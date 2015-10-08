package collections;

import java.util.HashMap;
import java.util.Map;

public class HashMap_ex {

	public static void main(String[] args) {
		Map<String, HashMap> products = new HashMap<String, HashMap>();
		HashMap<String, String> item = new HashMap<String, String>();
		
		item.put("Price", "price value 1");
		item.put("Prorucer", "producer value 1");
		
		products.put("First", item);
		
		item = new HashMap<String, String>();
		
		item.put("Price", "price value 2");
		item.put("Prorucer", "producer value 2");
		
		products.put("Second", item);
		
		System.out.println(products);
	}

}
