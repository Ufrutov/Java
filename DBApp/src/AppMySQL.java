import java.sql.*;

public class AppMySQL {

	public static void main(String[] args) {
//		Connection object
		Connection db_link = null;
		
//		Open connection
		try {
			Class.forName("com.mysql.jdbc.Driver");
			db_link = DriverManager.getConnection("jdbc:mysql://localhost/university?user=root");
			
//			Create table in db
//			"CREATE TABLE students ( name VARCHAR(20), lastname VARCHAR(20), year INT, faculty VARCHAR(30) );"
			
			System.out.println("AppMySQL");
			
			String query = "CREATE TABLE IF NOT EXISTS students" +
					"(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ," +
					"name VARCHAR(20)," +
					"lastname VARCHAR(20)," +
					"year INT," +
					"faculty VARCHAR(30) );";
			Statement command = db_link.createStatement();
			command.executeUpdate(query);
			
			query = "INSERT INTO students VALUES ( null, 'John', 'Travolta', 4, 'Film & Action' )";
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
