package RegExDate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDateApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fragment = "Lenin was born at the 27.03.1887. Went to Germany at 19.01.1905. Returned to Russia at 17.11.1917.";
		
		String reg = "(\\d{2}.\\d{2}.\\d{4})";
		
		Pattern ptrn = Pattern.compile(reg);
		
		Matcher m = ptrn.matcher(fragment);
		
		ArrayList<String> list = new ArrayList<String>();
		
		while( m.find() ) {
			System.out.println(m.start());
			list.add(m.group());
		}
		
		System.out.println("Found "+list.size()+" elements:");
		
		Iterator index = list.iterator();
		
		while( index.hasNext() ) {
			System.out.println(index.next());
		}
		
	}

}
