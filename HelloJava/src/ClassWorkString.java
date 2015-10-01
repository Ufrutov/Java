import java.util.Scanner;

public class ClassWorkString {

	public static void main(String[] args) {
		// Enter phrase, replace word
		
		Scanner in = new Scanner(System.in);
		
		String phrase;
		String word;
		String replace;
		
		System.out.println("Enter phrase:");
		
		phrase = in.nextLine();
		
		System.out.println("Enter word to replace:");
		
		word = in.nextLine();
		
		System.out.println("Enter replacement");
		
		replace = in.nextLine();
		
		if( phrase.indexOf(word) == -1 )
			System.out.println("[!] Can't search entered word - "+word);
		else
			System.out.println("Result: "+phrase.replace(word, replace));
		
		in.close();
	}

}
