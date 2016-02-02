package chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MessageQuery {
	
	private static Statement command;
	private static Connection db_link = null;
	
	public static void start() {
		try {
			Class.forName("org.sqlite.JDBC");
			db_link = DriverManager.getConnection("jdbc:sqlite:caht.db");
			
			String query = "CREATE TABLE IF NOT EXISTS msg" +
					"(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
					"message TEXT," +
					"date VARCHAR(20)," +
					"ip VARCHAR(20) );";
			command = db_link.createStatement();
			command.executeUpdate(query);
			
			System.out.println("sqlite.JDBC started!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Boolean insert(Message m) {
		String query = String.format("INSERT INTO msg VALUES ( null, '%s', '%s', %d, '%s' )", m.message, m.date, m.ip);

		try {
			command.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void delete(int id) {
		String query = String.format("DELETE FROM msg WHERE id = %d", id);
		try {
			command.executeUpdate(query);
			System.out.format("Deleted msg with id %d;", id);
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
