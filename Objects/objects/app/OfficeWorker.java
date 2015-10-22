package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class OfficeWorker {
	
	public static String office = "of. 607"; 
	public static String printer = "HP1100";
	public static String teapot = "Tefal";
	
	public String name;
	public String workstation;
	private Float salary;
	public String job;
	
//	Setter for private property salary
	public void setSalary(Float newSalary) {
		if( newSalary <= 0 )
			System.out.println("[!] Invalid Salary value: "+newSalary);
		else
			this.salary = newSalary;
	}
	
//	Setter for public property workstation
	public void setWorkstation() {
		System.out.println("Select workstation from available machines:");
		
		while(true) {
			List<String> list = Arrays.asList("Lap-1", "Lap-2", "Lap-3", "Mac", "Desk-X");
			Iterator index = list.iterator();
			while( index.hasNext() ) {
				
				String name = index.next().toString();
				System.out.println(name);
			}
			
			Scanner in = new Scanner(System.in);

			String input = in.nextLine();
			if( list.contains(input.trim()) ) {
				this.workstation = input;
				break;
			} else
				System.out.println("[E] Wrong input, try again");
		}		
	} 
	
//	getter for private property Salary
	public Float getSalary() {
		return this.salary;
	}
	
	private void showList() {
		// TODO Auto-generated method stub
		
	}

	public OfficeWorker(String name, String workstation, Float salary,
			String job) {
		super();
		this.name = name;
		this.workstation = workstation;
		this.salary = salary;
		this.job = job;
	}

	public void info() {
		System.out.println("---------------------------");
		System.out.printf("Office name: %s\n", this.office);
		System.out.printf("Office printer: %s\n", this.printer);
		System.out.printf("Office teapot: %s\n", this.teapot);
		
		System.out.printf("Workers name: %s\n", this.name);
		System.out.printf("Works on %s, earns - %s, speciality - %s\n", 
				this.workstation, this.salary, this.job);
		System.out.println("---------------------------");
	}

	@Override
	public String toString() {
		return "OfficeWorker [name=" + name + ", workstation=" + workstation
				+ ", salary=" + salary + ", job=" + job + "]";
	}
	
}
