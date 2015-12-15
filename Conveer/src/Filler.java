
public class Filler extends Thread {
	
	private Box b;
	
	Filler( Box b ) {
		this.b = b;
	}
	
	public void run() {
		int bottles = 0;
		
		synchronized (this) {
			for( int n = 1; n <= 10; n++ ) {
	//			[1]
				if( ( bottles == 0 ) )
					bottles = this.fill();
	//			[2]
				if( !this.b.put(bottles) ) {
					int bts = b.getBottles();
					System.out.println("["+n+"][F] FILLER: can't put "+bottles+" bottles, waiting... ("+bts+")");
					try {
	//					this.sleep(50);
						this.wait(3000);
					} catch (InterruptedException e) {
						e.printStackTrace(); }
				} else {
					int bts = b.getBottles();
					System.out.println("["+n+"][S] FILLER: put success "+bottles+" ("+bts+")");
					bottles = 0;
					this.notifyAll();
				}
			}
		}
	}
	
	public int fill() {
		int bottles = (int)(Math.random() * 36);
		return bottles;
	}
	
}
