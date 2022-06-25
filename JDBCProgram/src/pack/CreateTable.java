package pack;

import java.sql.*;

public class CreateTable {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			String q = "create table table1(tId int(20) primary key auto_increment, tName varchar(200) not null , tcity varchar(400))";
			 stmt = conn.createStatement();
			stmt.executeUpdate(q);
			System.out.println("Table created...");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
