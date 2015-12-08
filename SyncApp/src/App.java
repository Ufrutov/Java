
public class App {

	public static void main(String[] args) {
		
		Restaraunt Pub1 = new Restaraunt("Pub1");
		
		Customer client1 = new Customer("C1", Pub1);
		Customer client2 = new Customer("C2", Pub1);
		Customer client3 = new Customer("C3", Pub1);
		
		Pub1.start();
		client1.start();
		client2.start();
		client3.start();
		
		Pub1.stats();
		
	}

}
