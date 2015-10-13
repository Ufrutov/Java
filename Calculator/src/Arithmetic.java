
public class Arithmetic {
	
	public static int Last_result = 0;
	
	public static void add(int a, int b){
		Last_result = a+b;
		show();
	};
	
	public static void sub(int a, int b){
		Last_result = a-b;
		show();
	};
	
	public static void mult(int a, int b){
		Last_result = a*b;
		show();
	};
	
	public static void div(int a, int b){
		Last_result = a/b;
		show();
	};
	
	public static void show() {
		System.out.println( "Result: "+Last_result );
	};
	
}
