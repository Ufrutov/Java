
public class Plumber extends Thread {
	
	Box b;
	
	Plumber(Box b) {
		this.b = b;
	}
	
	public void run() {
		int bottles = 0;
		synchronized(this) {
			for( int n = 1; n <= 10; n++ ) {
	//			[1]
				if( ( bottles == 0 ) )
					bottles = this.plumb();
	//			[2]
				if( !this.b.take(bottles) ) {
					int bts = b.getBottles();
					System.out.println("["+n+"][F] PLUMBER: can't take "+bottles+" bottles, waiting... ("+bts+")");
					try {
	//					this.sleep(125);
						this.wait(3000);
					} catch (InterruptedException e) {
						e.printStackTrace(); }
				} else {
					int bts = b.getBottles();
					System.out.println("["+n+"][S] PLUMBER: take success "+bottles+" ("+bts+")");
					bottles = 0;
					this.notifyAll();
				}
			}
		}
	}
	
	public int plumb() {
		int bottles = (int)(Math.random() * 36);
		return bottles;
	}
	
}
