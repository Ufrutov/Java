package main;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Calc {
	
	public static Boolean enable = false;
	private static Map<String, HashMap<Float, Integer>> total = new HashMap<String, HashMap<Float, Integer>>();
	private static HashMap<Float, Integer> record;
	
	public static void collect(Class<?> item, int count) {
		if( !enable )
			enable = true;
		Field price = null, name = null;
		try {
			price = item.getField("price");
			name = item.getField("name");
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			record = new HashMap<Float, Integer>();
			String index = name.get(name).toString();
			Float productPrice = (Float)price.get(price);
			
			if( total.containsKey(index) ) {
				record = total.get(index);
				Integer oldValue = record.get(productPrice);
				record.put(productPrice, oldValue+count);
			}  else {
				record.put(productPrice, Integer.valueOf(count));
			}
			total.put(index, record);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void showTotal() {
		System.out.println("[Your Bill]");
		byte i = 0;
		Float pay = 0.0f;
		for( Map.Entry<String, HashMap<Float, Integer>> entry: total.entrySet() ) {
			i++;
			Float key = entry.getValue().keySet().iterator().next();
			Integer price = entry.getValue().get(key);
			pay += (Float)key*price;
			System.out.printf("%d: %s - %.2fmdl - %d [%.2fmdl]\n", i, entry.getKey(), key, price, pay);
		}
		System.out.printf("Total: %.2fmdl\n\n", pay);
		total = new HashMap<String, HashMap<Float, Integer>>();
		enable = false;
	}
	
}
