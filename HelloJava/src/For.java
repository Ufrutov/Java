public class For {

	public static void main(String[] args) {
		
		byte[] notes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		byte i = 0;
		
		while( i < notes.length ) {
			System.out.println(notes[i]);
			notes[i] = (byte)((i+1)*2);
			i++;
		}
		i = 0;
		while( i < notes.length ) {
			System.out.println("> "+notes[i]);
			i++;
		}
		
		
	}

}
