import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name;
		byte age;
		
		Scanner in = new Scanner(System.in);
		
		File f = new File("person.txt");
		
		try {
			FileWriter out = new FileWriter(f, true);
			
			while( true ) {
				
				System.out.println("Enter person name:");
				
				name = in.nextLine();
				
				System.out.println("Enter person age:");
				
				age = in.nextByte();
				
				if( age == 0 ) {
					System.out.println("[S] Stopped");
					break;
				}
				
				out.write(name+", "+age+" ages old\n");
				
				System.out.println("New person: "+name+" : "+age);
				
				in = new Scanner(System.in);
				
			}
			
			out.close();
			
			Scanner read = new Scanner(f);

			while(read.hasNextLine()) {
				System.out.println(read.nextLine());
			}
			
			read.close();
			in.close();
			
		} catch (IOException e) {
			System.out.println("Can't access requested file"+f.getName());
//			e.printStackTrace();
		}
	}

}
