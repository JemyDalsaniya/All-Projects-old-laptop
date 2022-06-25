package pack;
import pack.ConnectionClass;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class User_login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public User_login() {
		super();
	}

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
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username.isEmpty() || password.isEmpty()) {
			out.println("Please Enter correct details!!");
			RequestDispatcher req = request.getRequestDispatcher("/login.jsp");
			req.include(request, response);
		} else {

			try {
				
				PreparedStatement pstmt = conn.prepareStatement(
						"select fname,lname from registration where username = ? and password = ?");
				
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					
					response.setHeader("Cache-Control","no-cache"); 
					response.setHeader("Cache-Control","no-store");
					response.setDateHeader("Expires", 0); 
					response.setHeader("Pragma","no-cache"); 
					
					String firstname = rs.getString("fname");
					String lastname = rs.getString("lname");
				
					
					//session.setAttribute("username", username);

					HttpSession session = request.getSession();
					
					session.setAttribute("fname", firstname); 
					session.setAttribute("lname", lastname);
					response.sendRedirect("WelcomeServlet");
				} else {
					out.println("Enter Valid User name and Password...");
					RequestDispatcher req = request.getRequestDispatcher("/login.jsp");
					req.include(request, response);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
