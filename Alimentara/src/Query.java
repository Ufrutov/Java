import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class Query {
	
	private static Statement command;
	private static Connection db_link = null;
	
	public static void start() {
		try {
			Class.forName("org.sqlite.JDBC");
			db_link = DriverManager.getConnection("jdbc:sqlite:alimentara.db");
			
			String query = "CREATE TABLE IF NOT EXISTS products" +
					"(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
					"name VARCHAR(20)," +
					"desc TEXT," +
					"price FLOAT," +
					"expdate DATETIME );";
			
			command = db_link.createStatement();
			command.executeUpdate(query);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void list(int id) {
		String query;
		if( id <= 1 )
			query = "SELECT * FROM products";
		else
			query = String.format("SELECT * FROM products WHERE id=%d", id);
		
		try {
			ResultSet rs = command.executeQuery(query);

			int i = 0;
			while (rs.next()) {
				if( i == 0 )
					System.out.format("%s: %s \t| %s \t| %s \t| %s \t| %s\n",
						"#",
						"id",
						"name",
						"desc",
						"price",
						"expiration date");
				i++;
				System.out.format("%d: %s \t| %s \t| %s \t| %s mdl \t| %s\n", i,
					rs.getString("id"),
					rs.getString("name"),
					rs.getString("desc"),
					rs.getString("price"),
					Product.formatDate(rs.getString("expdate"), "d/m/y"));
			}
			System.out.println("Total number of products: "+i);
			if( i == 0 )
				System.out.println("[E] DB table is empty..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void insert(Product p) {
		String query = String.format("INSERT INTO products VALUES ( null, '%s', '%s', %f, '%s' )", p.name, p.desc, p.price, p.expdate);

		try {
			command.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("INSERT EXCEPTION");
			e.printStackTrace();
		}
	}
	
	public static void update(int id) {
		Scanner in = new Scanner(System.in);
		Query.list(id);
		
		System.out.println("Enter field:");
		String field = in.nextLine();
		String[] fields = {"name", "desc", "price"};
		
		if( Arrays.asList(fields).contains(field) ) {
			String query;
			System.out.println("Imput new value:");
			String value = in.nextLine();
			
			if( field == "price" )
				query = String.format("UPDATE products SET %s=%f WHERE id=%d;", field, Float.valueOf(value), id);
			else
				query = String.format("UPDATE products SET %s=\"%s\" WHERE id=%d;", field, value, id);
			
//			System.out.println(query);
			
			try {
				command.executeUpdate(query);
			} catch (SQLException e) {
				System.out.println("UPDATE EXCEPTION");
				e.printStackTrace();
			}
			
			Query.list(id);
		} else
			System.out.println("[E] Sorry, You can't modify this field: "+field);
		
		in.close();
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
