package com.ecommerce;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			Statement stmt = conn.getDBConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); // Same as JDBCStatements Example.
			
			//Insert Operation
			stmt.executeUpdate("insert into eproduct (name, price, date_added) values ('May Product', 57800.00, now())");
			out.println("Executed an insert operation<br>");
			
			//Update Operation
			 stmt.executeUpdate("update eproduct set price=69000 where name = 'May Product'");
             out.println("Executed an update operation<br>");
             
           //Delete Operation
             stmt.executeUpdate("delete from eproduct where name = 'zzz product'");
             out.println("Executed a delete operation<br>");

           //Read - Execute a SQL Query
 			ResultSet rst = stmt.executeQuery("select * from eproduct"); //Run a SQL Query.
 			//Print the Results from the eproduct table.
 			List<Integer> IDDetails = new ArrayList<Integer>();
 			
 			while(rst.next())
 			{
 				int id = rst.getInt("ID");
 				IDDetails.add(id);
 				out.println(id+" ,"+rst.getString("name")+"<br>");//Print row by row from the table.
 			}

 			out.println("ID DATA: "+IDDetails.toString());
			
			
			stmt.close();
			// Close the Connection.
			conn.closeConnection();
			out.println("DB Connection Closed.<br>");

			out.println("</body></html>");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
