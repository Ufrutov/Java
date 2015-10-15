package ExchangeRate;

public class Exchange {
	public static float value;
	public static float usd = 19.77f;
	public static String rate;
	public static String unrate;
	public static float result;
	
	public static void convert() {
		unrate = rate.equals("USD") ? "MDL" : "USD"; 
		switch ( rate ) {
			case "MDL":
				result = value/usd;
				break;
			case "USD":
				result = value*usd;
				break;
		}
		
		System.out.println("Convert "+value+" "+rate+" to "+unrate+" [Rate: "+usd+"]:");
		System.out.printf("Result is %.2f %s;\n\n", result, unrate);
		
		if( !History.enable )
			History.enable = true;
		
		History.save(rate, unrate, value, result);
		
	}
}
