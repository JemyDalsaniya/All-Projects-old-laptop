package productservlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import productDAO.ProductDAO;
import packProduct.Product;

public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1;
		int recordsPerPage = 10;
		if (request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		ProductDAO dao = new ProductDAO();
		List<Product> list = dao.viewAllProducts((page - 1) * recordsPerPage, recordsPerPage);
		int noOfProducts = dao.getnoOfProducts();
		int noOfPages = (int) Math.ceil(noOfProducts * 1.0 / recordsPerPage);
		request.setAttribute("ProductList", list);
		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("currentPage", page);
		RequestDispatcher view = request.getRequestDispatcher("displayProduct.jsp");
		view.forward(request, response);
	}
}
