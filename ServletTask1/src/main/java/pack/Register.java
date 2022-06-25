package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pack.ConnectionClass;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//created Connection class object
	Connection conn;

	public void init(ServletConfig config) throws ServletException {
		// create connection
		try {
			conn = ConnectionClass.getInstance().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// TODO Auto-generated method stub
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String address = request.getParameter("address");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String contact = request.getParameter("contact");
		Matcher match = ptrn.matcher(contact);

		// validation for the entered user data
		if (first_name.isEmpty() || last_name.isEmpty() || username.isEmpty() || password.isEmpty() || address.isEmpty()
				|| contact.isEmpty()) {

			out.println("Please Enter Details!!");
			RequestDispatcher req = request.getRequestDispatcher("register.html");
			req.include(request, response);
		} 
		else if (!(first_name.matches("^[a-zA-Z]*$") || last_name.matches("^[a-zA-Z]*$")
				|| username.matches("^[a-zA-Z]*$"))) {
			out.println("Enter valid Name!!");
			RequestDispatcher req = request.getRequestDispatcher("register.html");
			req.include(request, response);
		} else if (!(match.find() && match.group().equals(contact))) {
			out.println("Enter valid Phone number!!");
			RequestDispatcher req = request.getRequestDispatcher("register.html");
			req.include(request, response);
		} 
		else {
			
			try {


				String q = "insert into registration(fname,lname,address,username,password,contact) values(?,?,?,?,?,?)";
				PreparedStatement pstmt = conn.prepareStatement(q);

				pstmt.setString(1, first_name);
				pstmt.setString(2, last_name);
				pstmt.setString(3, address);
				pstmt.setString(4, username);
				pstmt.setString(5, password);
				pstmt.setString(6, contact);
				pstmt.executeUpdate();

				RequestDispatcher req = request.getRequestDispatcher("/login.jsp");
				req.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
