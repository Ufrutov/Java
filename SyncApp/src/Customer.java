
public class Customer extends Thread {
	
	public String name;
	public Restaraunt local;
	
	Customer( String name, Restaraunt local ) {
		this.name = name;
		this.local = local;
	}
	
//	Runnable function from parent Thread class
	public void run() {
		
		for( int day=1; day<=31; day++ ) {
			for( int p=1; p<=7; p++ ) {
				this.eat();
			}

		}
		
	}
	
	public synchronized void eat() {
//		synchronize block
		synchronized (local) {
			if( local.stock > 0 ) {
		//		Pause cooking for 1 day (24 ms)
				try {
					this.sleep(43);
				} catch (InterruptedException e) {
					e.printStackTrace(); }
			
				local.stock--;
			}
			
		}
	}
}
