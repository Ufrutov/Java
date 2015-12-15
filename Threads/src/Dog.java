
public class Dog extends Thread {
	
	private String name;
	private static int i = 0;
	private static int food = 5000;
	
	public Dog(String name) {
		this.name = name;
	}
	
//	Override run() function
	
	public void run() {
//		bark();
		eat();
	}
	
	public void eat() {
		int portion;
		while( food > 0 ) {
			portion = (int) ( Math.random()*100 );
			System.out.println( this.name + " : " + portion + "gr. " + food);
			if( food >= portion )
				food -= portion;
			else
				food -= food;
		}
		System.out.println( this.name + " THE END!! Food remained " + food);
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
