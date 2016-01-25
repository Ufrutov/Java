package student;

import java.util.List;

import query.QueryDB;

public class Student {
	
	public int id;
	public String name;
	public String lastname;
	public int year;
	public String faculty;
	
	public Student(int id, String name, String lastname, int year, String faculty) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.year = year;
		this.faculty = faculty;
	}
	
	public Student(String name, String lastname, int year, String faculty) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.year = year;
		this.faculty = faculty;
	}

	public static List<Student> liststudents() {
		return QueryDB.list();
	}
	
}
