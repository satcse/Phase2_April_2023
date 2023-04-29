package com.ecommerce;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductDetails
 */
@WebServlet("/ProductDetails")
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			out.println("<html><body>");

			// Get the URL, username, password from the config.properties file and load into
			// props object.
			InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties"); // Java NIO Package.
			Properties props = new Properties();
			props.load(in);

			DBConnection conn = new DBConnection(props.getProperty("url"), props.getProperty("userid"),
					props.getProperty("password"));
			out.println("DB Connection Successful!<br>");

			/*
			 * Step 1 - Create the Stored Procedure in the MySQL DB. CREATE PROCEDURE
			 * ecommerce.add_productMay(IN pname varchar(100), IN pprice decimal(10,2))
			 * INSERT INTO ecommerce.eproduct (name, price) VALUES (pname, pprice);
			 */

			// Step 2- Use the CallableStatement - Good for Calling the Stored Procedures.
			CallableStatement stmt = conn.getDBConnection().prepareCall("{call add_productMay(?,?)}");
			stmt.setString(1, "May OnePlus");
			stmt.setBigDecimal(2, new BigDecimal(1952.20));
			stmt.executeUpdate();

			out.println("Stored Procedures has been executed.<br>");
			stmt.close();
			conn.closeConnection();
			out.println("</body></html>");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
