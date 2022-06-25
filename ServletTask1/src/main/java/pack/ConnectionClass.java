package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

	private static ConnectionClass object = null;

	private ConnectionClass() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ConnectionClass getInstance() {
		if (object != null)
			return object;
		else {
			object = new ConnectionClass();
			return object;
		}

	}

	public static Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");

		return conn;
	}
}
