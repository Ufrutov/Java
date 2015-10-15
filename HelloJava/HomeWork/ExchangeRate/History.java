package ExchangeRate;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class History {
	public static Boolean enable = false;
	private static Map<String, HashMap<String, String>> history = new HashMap<String, HashMap<String, String>>();
	private static HashMap<String, String> record;
	
	public static void save( String from, String to, float value, float result ) {
		record = new HashMap<String, String>();
		
		record.put("From", from);
		record.put("To", to);
		record.put("Value", String.format("%.2f", value));
		record.put("Result", String.format("%.2f", result));
		
		history.put(Calendar.getInstance().getTime().toString(), record);
		
	}
	
	public static void print() {
		System.out.println("[History]");
		byte i = 0;
		for( Map.Entry<String, HashMap<String, String>> entry: history.entrySet() ) {
			i++;
			System.out.println(i+". "+entry.getKey());
			System.out.printf("Convert from %s %s to %s %s;\n\n", entry.getValue().get("Value"), entry.getValue().get("From"), entry.getValue().get("Result"), entry.getValue().get("To") );
		}
	}
}
