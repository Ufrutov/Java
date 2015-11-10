import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String fragment = "James Francis Cameron[2] (born August 16, 1954) is a "
				+ "Canadian filmmaker, inventor, engineer, philanthropist, "
				+ "and deep-sea explorer.[3][4] He first found major success "
				+ "with the science fiction action film The Terminator (1984). "
				+ "He then became a popular Hollywood director and was hired "
				+ "to write and direct Aliens (1986); three years later he "
				+ "followed up with The Abyss (1989). He found further critical "
				+ "acclaim for his use of special effects in "
				+ "Terminator 2: Judgment Day (1991). After his film True Lies "
				+ "(1994) J.C. took on his biggest film at the time, Titanic "
				+ "(1997), which earned him Academy Awards for Best Picture, "
				+ "Best Director and Film Editing. After Titanic, Cameron "
				+ "began a project that took almost 10 years to make: "
				+ "his science-fiction epic Avatar (2009), which was in "
				+ "particular a landmark for 3D technology, and for which "
				+ "he received nominations for the same three Academy Awards. "
				+ "In the time between making Titanic and Avatar, James Cameron spent "
				+ "several years creating many documentary films "
				+ "(specifically underwater documentaries) and co-developed "
				+ "the digital 3D Fusion Camera System. Described by a biographer "
				+ "as part scientist and part artist,[5] Cameron has also "
				+ "contributed to underwater filming and remote vehicle "
				+ "technologies.[3][4][6] On March 26, 2012, Cameron "
				+ "reached the bottom of the Mariana Trench, the deepest "
				+ "part of the ocean, in the Deepsea Challenger submersible.["
				+ "7][8][9] He is the first person to do this in a solo "
				+ "descent, and is only the third person to do so ever.";
		
//		Cameron
//		James Francis Cameron
//		James Cameron
		
		String tmplt = "(James )?(Francis )?Cameron";
		String x = "J.C.";
		
//		Prepare template for compilation
		Pattern p = Pattern.compile(tmplt);
//		Match ptemplate in text
		Matcher m = p.matcher(fragment);
		
		List<String> allMatches = new ArrayList<String>();
		
		if( m.find() ) {
			
			 while (m.find()) {
			   allMatches.add(m.group());
			 }
			
			System.out.println("Got it!");
		} else {
			System.out.println("Failure");
		}
		
		System.out.println(fragment);
		
		int i = fragment.length();
		while(i>0) {
			System.out.print("-");
			i--;
		}
		
		System.out.println("\n"+m.replaceAll(x));
		
		Iterator index = allMatches.iterator();
		
		while( index.hasNext() ) {
			System.out.println(index.next());
		}
		
	}

}
