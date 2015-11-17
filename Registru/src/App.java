
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person("John", "Dee", (byte) 33, "worker");
		
		p1.save();
		
		Person p2 = new Person("John2", "Dee", (byte) 33, "worker");
		
		p2.save();
		
		Person p3 = new Person("John3", "Dee", (byte) 33, "worker");
		
		p3.save();
	}

}
