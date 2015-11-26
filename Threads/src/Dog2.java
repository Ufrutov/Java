
public class Dog2 extends Thread {
	
	private String name;
	private static int i = 0;
	
	public Dog2(String name) {
		this.name = name;
	}
	
//	Override run() function
	
	public void run() {
		bark();
	}
	
	public void bark() {
		while( true ) {
			System.out.println(this.name+": Woof! Woof! ("+(i++)+")");
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if( i > 50 ) {
				break;
			}
		}
	}
}
