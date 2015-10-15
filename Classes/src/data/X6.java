package data;

public class X6 extends Car {
	public static String name = "X6";
	
	public static void info () {
		SportCar.info();
		Car.print("Model name: "+name);
	}
	
	public void car() {
		super.info();
	}
}
