package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// created Connection class object
	/*
	 * Connection conn;
	 * 
	 * public void init(ServletConfig config) throws ServletException { // create
	 * connection try { conn = ConnectionClass.getInstance().getConnection(); }
	 * catch (SQLException e) { e.printStackTrace(); } }
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
		response.setHeader("Pragma", "no-cache");

		HttpSession session = request.getSession(false);

		if (session != null) {
			String first_name = (String) session.getAttribute("fname");
			String last_name = (String) session.getAttribute("lname");

			out.println("Welcome " + first_name + " " + last_name);
			out.print("<br/><a href=\"Logout\">Logout</a>");

		} else {
			response.sendRedirect("login.jsp");
		}

	}
}
