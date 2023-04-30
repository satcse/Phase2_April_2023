package com.ecommerce;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
		try
		{
			SessionFactory factory = HibernateUtil.getSessionFactory();
            
            Session session = factory.openSession();
            
             
            // Eager Loading - Will load all tables Eproduct, os, Colors, Finance, ScreenSizes (All 5 tables!)
            // Lazy Loading - Will load only Eproduct table and Finance table! Other 3 tables are NOT loaded.
            List<EProduct> list = session.createQuery("from EProduct").list(); 
            
             PrintWriter out = response.getWriter();
             out.println("<html><body>");
             out.println("<b>Product Listing</b><br>");
             
             for(EProduct p: list) {
                 out.println("ID: " + String.valueOf(p.getID()) + ", Name: " + p.getName() +
                                 ", Price: " + String.valueOf(p.getPrice()) + ", Date Added: " + p.getDateAdded().toString());
                 
                 //Print all the colors for this eproduct
                 List<Color> colors = p.getColors(); // Lazy Loading Only - Colors table will be loaded.
                 out.println("Colors: ");
                 for(Color c: colors)
                 {
                	 out.print(c.getName() + "&nbsp;");
                 }
                 
                 //Print all the ScreenSizes available for this eproduct
                 Collection<ScreenSizes> sizes= p.getScreenSizes();// Lazy Loading Only - ScreenSizes table will be loaded.
                 out.println(", Screen Sizes: ");
                 for(ScreenSizes s: sizes) {
                         out.print(s.getSize() + "&nbsp;");
                 }
                 
                 //Print all the OS options available for this eproduct
                 Set<OS> os= p.getOs(); // Lazy Loading Only - Os table will be loaded.
                 out.println(", OS : ");
                 for(OS o: os) {
                         out.print(o.getName() + "&nbsp;");
                 }

                 //Print all Finance Options available for this eproduct
                 Map finances = p.getFinance();
                 out.println(", Finance Options: ");
                 if (finances.get("CREDITCARD") != null) {
                        Finance f = (Finance) finances.get("CREDITCARD");
                        out.println(f.getName() + " &nbsp;");
                 }
                 if (finances.get("BANK") != null) {
                        Finance f = (Finance) finances.get("BANK");
                        out.println(f.getName() + " &nbsp;");
                 }
                 out.println("<hr>");
             }
             session.close();
             out.println("</body></html>");         
		}catch(Exception ex)
		{
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
