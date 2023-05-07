package com.ecommerce;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Servlet implementation class ListProducts
 */
@WebServlet("/ListProducts")
public class ListProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListProducts() {
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
			// Establish the connection.
			SessionFactory factory = HibernateUtil.getSessionFactory(); // Take the SessionFactory Object from the
																		// Hibernate Util File.
			Session session = factory.openSession();
			Transaction transaction = null;
			out.println("Hibernate Session opened.<br>");

			// Read Query - Create a Query using HQL.
			List<EProduct> list = session.createQuery("from EProduct").list();

			// Iterate through the results.
			for (EProduct p : list) {
				out.println("ID: " + String.valueOf(p.getID()) + ", Name: " + p.getName() + ", Price: "
						+ String.valueOf(p.getPrice()) + ", Date Added: " + p.getDateAdded().toString() + "<br>");

			}
			out.println("Hibernate Session closed.<br>");
			out.println("</body></html>");

			// Insert Query
			EProduct newProduct = new EProduct();
			newProduct.setName("Hibernate New Product");
			newProduct.setPrice(new BigDecimal(325.24));
			newProduct.setDateAdded(new Date());
			transaction = session.beginTransaction();
			session.save(newProduct);
			out.println("Insert Hibernate Completed.");
			transaction.commit();
			
			//Update Query
			EProduct updateProduct = session.get(EProduct.class, 28L);
			out.println("Update Product: "+updateProduct.getName()+" ,"+updateProduct.getPrice());
			updateProduct.setPrice(new BigDecimal(13575.00));
			transaction = session.beginTransaction();
			session.save(updateProduct);
			out.println("Update Hibernate Completed.");
			transaction.commit();
			
			//Delete Query
			EProduct deleteProduct = session.get(EProduct.class, 26L);
			out.println("deleteProduct: "+deleteProduct.getName()+" ,"+deleteProduct.getPrice());			
			transaction = session.beginTransaction();
			session.delete(deleteProduct);
			out.println("Delete Hibernate Completed.");
			transaction.commit();
			
			session.close();
		} catch (Exception ex) {
			throw ex;
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
