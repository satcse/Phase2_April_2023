

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet implementation class NameServlet
 */

public class NameServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public NameServlet() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		String fname = arg0.getParameter("fname");
		String lname = arg0.getParameter("lname");
		
		PrintWriter out = arg1.getWriter();
		 out.println("<html><body>");
         out.println("Your full name is " + fname + " " + lname);
         out.println("</body></html>");		
	}

}
