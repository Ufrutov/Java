package data;

public class SportCar extends Car {
	
	public static short speed = 300;
	
	public static void info() {
		Car.info();
		print("Model speed: "+speed);
	}

}
