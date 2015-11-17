
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Person {
	
	private int id;
	private String fname;
	private String lname;
	private byte age;
	private String job;
	
	final static String dir = System.getProperty("user.dir");
	private static File dataFile = new File(dir+"\\persons.txt");
	
	public Person(String fname, String lname, byte age, String job) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.job = job;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
//	Save and read data from file
	public void save() {
		int size = 0;
		try {
			
			if( this.dataFile.exists() ) {
				Scanner in = new Scanner(this.dataFile);
				while(in.hasNextLine()) {
					String line = in.nextLine();
					if( line.length() != 0 )
						size++;
				}
				in.close();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("[E] Error openning the file: "+this.dataFile.getPath());
			e.printStackTrace();
		}
		
		try {
			
			FileWriter fw = new FileWriter(this.dataFile, true);
			fw.write("id: "+(size+1)+" - "+this.fname+" "+this.lname+", "+this.age+", "+this.job+"\n");			
			fw.close();
			
		} catch (IOException e) {
			System.out.println("[E] Error openning the file: "+this.dataFile.getPath());
			e.printStackTrace();
		}
	}
	
	public void load() {
		
	}
}
