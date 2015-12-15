
public class App {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("----------------- * START * ---------------------");
		
		Box b = new Box(3);
		b.status();
		
		Filler f = new Filler(b);
		b.f = f;
		Plumber p = new Plumber(b);
		b.p = p;
		
		f.start();
		p.start();
		
		Thread.sleep(1000);
		
		System.out.println("----------------- *  END  * ---------------------");
		b.status();
	}

}
