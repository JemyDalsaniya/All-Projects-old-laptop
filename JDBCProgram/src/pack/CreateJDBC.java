package pack;
import java.sql.*;
public class CreateJDBC {

	public static void main(String[] args) {
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			if(conn.isClosed()) {
				System.out.println("Connection is still closed!");
			}
			else {
				System.out.println("Connection is created....");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
