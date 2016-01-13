import java.util.Scanner;

public class Student {
	public String name;
	public String lastname;
	public int year;
	public String faculty;
	
	Student() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter new student first name:");
		this.name = in.nextLine();

		System.out.println("Enter new student last name:");
		this.lastname = in.nextLine();

		System.out.println("Enter new student year:");
		this.year = Integer.valueOf(in.nextLine());

		System.out.println("Enter new student faculty:");
		this.faculty = in.nextLine();
	}
}
