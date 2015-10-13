package Partners;

public class Apple {
//	Properties
	public static String name = "Apple inc.";
	public static short year = 1976;
	public static long profit = 10000000000l;
	public static int employees = 1000000;
	
	public static String[] products = {"iPhone", "iPod", "MacBook"};
	
//	Composition
	
	public static class ceo{
		public static String name = "Tim C.";
		public static byte age = 56;		
	};
	
	public static class hq{
		public static String city = "San Francisco";
		public static String address = "O'Brain street";
		public static byte number = 77;
	}
	
	public static void about () {
		System.out.println("We are from "+hq.city+" at the "+hq.address+" "+hq.number);
		System.out.println("Our lider is "+ceo.name+", he is "+ceo.age+" years old.");
	}
	
}
