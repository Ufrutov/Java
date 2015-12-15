
public class Box {
	
//	limit max 6 bottles
	private int bottles;
	public Filler f;
	public Plumber p;
	
	Box() {}
	
	Box(int i) {
		this.bottles = i;
	}

	public int getBottles() {
		return bottles;
	}

	public void setBottles(int bottles) {
		if( bottles >= 0 && bottles <= 6 )
			this.bottles = bottles;
	}
	
	public void status() {
		System.out.println("Box: "+this.bottles+" bottles");
	}
	
	public boolean put(int i) {
		if( (this.bottles + i) <= 6 ) {
			this.bottles += i;
			return true;
		} else
			return false;
	}
	
	public boolean take(int i) {
		if( this.bottles == 0 )
			return false;
		
		if( this.bottles < i )
			i = this.bottles;
		
		if( this.bottles >= i ) {
			this.bottles -= i;
			return true;
		} else
			return false;
	}
	
}
