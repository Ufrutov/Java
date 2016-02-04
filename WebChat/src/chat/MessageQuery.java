package chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageQuery {
	
	private static Statement command;
	private static Connection db_link = null;
	private static Boolean start = false;
	private static Boolean stop = true;
	
	public static void start() {
		if( stop ) {
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
			start = true;
			stop = false;
		}
	}
	
	public static Boolean insert(Message m) {
		String query = String.format("INSERT INTO msg VALUES ( null, '%s', '%s', '%s' )", m.message, m.date, m.ip);

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
	
	public static JSONArray listJson() {
		String searchQuery = "SELECT  * FROM msg";
		
		JSONArray resultSet 	= new JSONArray(); 
		JSONObject returnObj 	= new JSONObject();
		
		ResultSet cursor;
		int i = 0;
		try {
			cursor = command.executeQuery(searchQuery);
			while( cursor.next() ) {
				Message m = new Message(
						Integer.valueOf(cursor.getString("id")),
						cursor.getString("message"),
						cursor.getString("date"),
						cursor.getString("ip"));
				
				returnObj = new JSONObject();
				try {
					returnObj.put("id", m.id);
					returnObj.put("message", m.message);
					returnObj.put("date", m.date);
					returnObj.put("ip", m.ip);
					
					resultSet.put(returnObj);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Count: "+i);
		return resultSet;
	}
	
	public static void stop() {
		if( start ) {
			try {
				command.close();
				db_link.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			start = false;
			stop = true;
		}
		
	}
}
