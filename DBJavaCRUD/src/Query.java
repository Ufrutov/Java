import java.sql.*;

public class Query {
	
	private static Statement command;
	private static Connection db_link = null;
	
	public static void start() {
		try {
			Class.forName("org.sqlite.JDBC");
			db_link = DriverManager.getConnection("jdbc:sqlite:university.db");
			
			String query = "CREATE TABLE IF NOT EXISTS students" +
					"( name VARCHAR(20)," +
					"lastname VARCHAR(20)," +
					"year INT," +
					"faculty VARCHAR(30) );";
			command = db_link.createStatement();
			command.executeUpdate(query);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void list() {
				
		try {
			ResultSet rs = command.executeQuery("SELECT * FROM students");

			int i = 0;
			while (rs.next()) {
				System.out.println(++i+". "+ rs.getString("name") +" | "+ rs.getString("lastname") +" | "+ rs.getString("year") +" | "+ rs.getString("faculty") + "\n");
			}
			if( i == 0 )
				System.out.println("[E] DB table is empty..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void insert(Student p) {
		String query = String.format("INSERT INTO students VALUES ( '%s', '%s', %d, '%s' )", p.name, p.lastname, p.year, p.faculty);

		try {
			command.executeUpdate(query);
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
