import java.sql.*;

public class App {

	public static void main_app() {
//	public static void main(String[] args) {
//		Connection object
		Connection db_link = null;
		
//		Open connection
		try {
			Class.forName("org.sqlite.JDBC");
			db_link = DriverManager.getConnection("jdbc:sqlite:university.db");
			
//			Create table in db
//			"CREATE TABLE students ( name VARCHAR(20), lastname VARCHAR(20), year INT, faculty VARCHAR(30) );"
			
			String query = "CREATE TABLE IF NOT EXISTS students" +
					"( name VARCHAR(20)," +
					"lastname VARCHAR(20)," +
					"year INT," +
					"faculty VARCHAR(30) );";
			Statement command = db_link.createStatement();
			command.executeUpdate(query);
			
			query = "INSERT INTO students VALUES ( 'John', 'Travolta', 4, 'Film & Action' )";
			command.executeUpdate(query);
			
			ResultSet rs = command.executeQuery("SELECT * FROM students");
			
			while (rs.next()) {
				System.out.println(rs.getString("name") +" | "+ rs.getString("lastname") +" | "+ rs.getString("year") +" | "+ rs.getString("faculty") + "\n");
			}
			
//			Close db connection
			command.close();
			db_link.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
