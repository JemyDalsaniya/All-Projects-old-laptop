package productDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import packProduct.Product;
import connectionDB.CreateConnection;

public class ProductDAO {
	Connection connection;
	Statement stmt;
	private int noOfProducts;

	public ProductDAO() { }

	//Connection to database
	private static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection con = CreateConnection.getInstance().getConnection();
		return con;
	}

	//list of product type to fetch data of table and return it through the method
	public List<Product> viewAllProducts(int start, int noOfProducts) {
		String query = "select SQL_CALC_FOUND_ROWS * from product limit " + start + ", " + noOfProducts;
		List<Product> list = new ArrayList<Product>();
		Product product = null;
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getDouble("product_price"));
				list.add(product);
			}
			rs.close();

			//to fetch from the resultset
			rs = stmt.executeQuery("SELECT FOUND_ROWS()");
			if (rs.next())
				//to get id of product
				this.noOfProducts = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public int getnoOfProducts() {
		return noOfProducts;
	}
}
