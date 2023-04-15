

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class InterfaceDemo
 */
@WebServlet("/InterfaceDemo")
public class InterfaceDemo implements Servlet {
	private static final long serialVersionUID = 1L;

	ServletConfig config = null;
	@Override
	public void destroy() {
		System.out.println("in destroy() method");
		
	}

	@Override
	public ServletConfig getServletConfig() {		
		return config;
	}

	@Override
	public String getServletInfo() {
	
		return "This is a sample Servlet info";
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		this.config=arg0;
		System.out.println("Initialization Complete");		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		arg1.setContentType("text/html");
		PrintWriter out = arg1.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("In the service() method<br>");
		out.print("</body>");
		out.print("</html>");
		
	}

    

}
