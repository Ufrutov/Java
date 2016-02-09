package query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {
	private static Statement command;
	private static Connection db_link = null;
	
	public Query() {
		
//		Clients = id, name, status, first_connect, last_connect
//		Messages = id, client, text, date
		
		try {
			Class.forName("org.sqlite.JDBC");
			db_link = DriverManager.getConnection("jdbc:sqlite:/db/chat.db");
			
			String query = "CREATE TABLE IF NOT EXISTS clients" +
					"(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
					"name VARCHAR(40)," +
					"status BOOLEAN," +
					"first_connect DATE," +
					"last_connect DATE )";
			
			command = db_link.createStatement();
			command.executeUpdate(query);
			
			query = "CREATE TABLE IF NOT EXISTS messages" +
					"(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
					"client INTEGER," +
					"text TEXT," +
					"date DATE )";
			
			command = db_link.createStatement();
			command.executeUpdate(query);
			
			System.out.println("sqlite.JDBC started!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static int online() {
		int online = 0;
		
		String query = String.format("SELECT * FROM %s WHERE status=1", "clients");
		
		ResultSet cursor;
		try {
			cursor = command.executeQuery(query);
			
			while(cursor.next()) {
				online++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return online; 
	}
	
	public static Object[] list(String table, int client) {
		Object[] output = null;
		String query = null;
		
		switch (table) {
			case "clients":
				query = String.format("SELECT * FROM %s", table);
				break;
			case "messages":
				query = String.format("SELECT * FROM %s WHERE client=%d", table, client);
				break;
		}
		
		ResultSet cursor;
		
		if( query != null )
			try {
				cursor = command.executeQuery(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return output;
	}
	
	public static Boolean update(String table, int id, String column, String value) {
		String query = null;
		switch (column) {
			case "status":
				query = String.format("UPDATE TABLE %s SET %s=%b WHERE id=%d", table, column, Boolean.getBoolean(value), id);
				break;
		}
		
		if( query != null )
			try {
				command.executeUpdate(query);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		else
			return false;
	}
	
	public static Boolean insertMessage(String table, int client, Message msg) {
		String query = String.format("INSERT INTO messages VALUES ( null, '%d', '%s', '%s' )", client, msg.text, msg.date);

		try {
			command.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void stop() {
		try {
			command.close();
			db_link.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
