package com.ecommerce;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
             PrintWriter out = response.getWriter();
			out.println("<html><body>");
			//Establish the connection.
			SessionFactory factory = HibernateUtil.getSessionFactory(); //Take the SessionFactory Object from the Hibernate Util File.
			Session session = factory.openSession();
			out.println("Hibernate Session opened.<br>");
			
			//Create a Query using HQL.
			List<EProduct> list = session.createQuery("from EProduct").list();
            session.close();
            
            //Iterate through the results.
            for(EProduct p: list)
            {
            	 out.println("ID: " + String.valueOf(p.getID()) + ", Name: " + p.getName() +
                         ", Price: " + String.valueOf(p.getPrice()) + ", Date Added: " + p.getDateAdded().toString() + "<br>");

            }
            out.println("Hibernate Session closed.<br>");			
			out.println("</body></html>");
		} catch (Exception ex) {
			throw ex;
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
