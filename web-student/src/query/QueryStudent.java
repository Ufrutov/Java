package query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import university.Student;

public class QueryStudent {
	
	private static Statement command;
	private static Connection db_link = null;
	
	public static void start() {
		try {
			Class.forName("org.sqlite.JDBC");
			db_link = DriverManager.getConnection("jdbc:sqlite:university.db");
			
			String query = "CREATE TABLE IF NOT EXISTS students" +
					"(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
					"name VARCHAR(20)," +
					"lastname VARCHAR(20)," +
					"year INT," +
					"faculty VARCHAR(30) );";
			command = db_link.createStatement();
			command.executeUpdate(query);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("[E] sqlite not found!");
			e.printStackTrace();
		}
	}
	
	public static String[] list() {
		String[] output = {};
		try {
			ResultSet rs = command.executeQuery("SELECT * FROM students");

			int i = 0;
			while (rs.next()) {
				i++;
				output[i] = ". ["+rs.getString("id")+"] "+ rs.getString("name") +" | "+ rs.getString("lastname") +" | "+ rs.getString("year") +" | "+ rs.getString("faculty");
			}

			return output;
		} catch (SQLException e) {
			e.printStackTrace();
			return output;
		}
	}
	
	public static void insert(Student p) {
		String query = String.format("INSERT INTO students VALUES ( null, '%s', '%s', %d, '%s' )", p.name, p.lastname, p.year, p.faculty);

		try {
			command.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void delete(int id) {
		String query = String.format("DELETE FROM students WHERE id = %d", id);
		try {
			command.executeUpdate(query);
			System.out.format("Deleted student with id %d;", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void stop() {
		try {
			command.close();
			db_link.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
