package file_objects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

public class Util {
	
	public static int countLines(File f) throws IOException {
		LineNumberReader  lnr = new LineNumberReader(new BufferedReader(new FileReader(f)));
		lnr.skip(Long.MAX_VALUE);
		int output = lnr.getLineNumber() + 1;
		lnr.close();
		
		return output;
	}
	
	public static Object createNew(String line) {
		String name = line.split(";")[0].split(":")[1].trim();
		String contains = line.split(";")[1].split(":")[1].trim();
		float price = Float.valueOf(line.split(";")[2].split(":")[1]);
		
		Pizza obj = new Pizza(name, contains, price);
		
		return obj;
	}
	
	public static void printInfo(byte i, ArrayList<Object> list) {
		
		if( i > list.size() || i <=0 ) { 
			System.out.println("[!] Wrong input. No such item.");
		} else {
			Object obj = list.get(i-1);
			Class<?> noparams[] = {};
			try {
				Method info = obj.getClass().getMethod("info", noparams);
				info.invoke(obj, null);
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static ArrayList<Object> printList() throws IOException {
		File file = new File("./objects/file_objects/db.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		ArrayList<Object> list = new ArrayList<Object>();
		
		int count = Util.countLines(file);
		int i;
		
		for( i=0; i < count; i++ ) {
			String line = br.readLine();
			list.add(Util.createNew(line));
		}
		
		System.out.println("Pizza List:");
		Iterator<Object> index = list.iterator();
		
		byte c = 1;
		while(index.hasNext()) {
			Object obj = index.next();
			String name = "Pizza";
			String brand = "Brand";
			try {
				name = obj.getClass().getField("name").get(obj).toString();
				brand = obj.getClass().getDeclaredField("brand").get(obj).toString();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.printf("%d) %s (%s)\n", c++, name, brand);
		}
		
		br.close();
		return list;
		
	}
	
	public static void addNew(String newLine) {
		File file = new File("./objects/file_objects/db.txt");
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("./objects/file_objects/db.txt", true)))) {
		    out.println();
		    out.print(newLine);
		}catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
	}
	
}
