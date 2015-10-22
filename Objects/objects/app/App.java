package app;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OfficeWorker w1 = new OfficeWorker("Steve", "Lap-1", 3500.0f, "Junior Ingeneer");
		OfficeWorker w2 = new OfficeWorker("Pete", "Desk-P", 4500.0f, "Meedle Ingeneer");
		OfficeWorker w3 = new OfficeWorker("Megan", "Lap-2", 2500.0f, "System Ingeneer");
		OfficeWorker w4 = new OfficeWorker("John", "Desk-J", 4000.0f, "Database Ingeneer");
		
		System.out.println(w1);
		System.out.println(w2);
		System.out.println(w3);
		System.out.println(w4);
		
		w3.printer = "Canon IR2200";
		
		w1.info();
		w2.info();
		
//		w3.salary += 1000f;
		w3.setSalary(-1000f);
		
		w3.setWorkstation();
		
		System.out.println(w3.getSalary());
		
		w3.info();
		
	}

}
