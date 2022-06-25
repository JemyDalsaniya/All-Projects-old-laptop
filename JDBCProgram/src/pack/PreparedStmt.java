package pack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
public class PreparedStmt {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			String q = "insert into table1(tName,tCity) values(?,?)";
			pstmt = conn.prepareStatement(q);
			//to get input from user
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter name:");
			String name = br.readLine();
			System.out.println("Enter city:");
			String city = br.readLine();

			//set the value to query..
			pstmt.setString(1, name);
			pstmt.setString(2, city);
			pstmt.executeUpdate();
			System.out.println("inserted...");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
