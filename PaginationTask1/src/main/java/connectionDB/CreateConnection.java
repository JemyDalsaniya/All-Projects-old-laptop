package connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import dao.ConnectionDB;

public class CreateConnection {
	private static CreateConnection obj = new CreateConnection();
	
	// private constructor
	private CreateConnection() {
     try {
         Class.forName("com.mysql.cj.jdbc.Driver");
     } catch (ClassNotFoundException e) {
         e.printStackTrace();
     }
 }

	public static CreateConnection getInstance() {
		return obj;
	}

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		if(connection.isClosed()) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
		return connection;
	}
}
