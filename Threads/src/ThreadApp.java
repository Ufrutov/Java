
public class ThreadApp {

	public static void main(String[] args) {
		
		Dog dog1 = new Dog("Dog1");
		Dog dog2 = new Dog("Dog2");
		Dog dog3 = new Dog("Dog3");
		Dog dog4 = new Dog("Dog4");
		Dog dog5 = new Dog("Dog5");
		
		dog1.start();
		dog2.start();
		dog3.start();
		dog4.start();
		dog5.start();

	}

}
