
public class Restaraunt extends Thread {
	
	public String name;
	public int stock;
	public final int limit = 100;
	
	Restaraunt( String name ) {
		this.name = name;
		this.stock = 0;
	}
	
	public void run() {
		
		for( int day=1; day<=31; day++ ) {
			for( int p=1; p<=8; p++ ) {
				this.cook();
			}
		}
		
	}
	
	public void cook() {
		this.stock++;
		
//		Pause cooking for 1 day (24 ms)
		try {
			this.sleep(72*2);
		} catch (InterruptedException e) {
			e.printStackTrace(); }
	}
	
	public void stats() {
		try {
			this.sleep(31*24+24);
		} catch (InterruptedException e) {
			e.printStackTrace(); }
		System.out.println("Restaurant "+this.name+" has in stock: "+this.stock);
	}
	
}
