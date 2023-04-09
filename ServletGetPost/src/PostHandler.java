

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostHandler
 */
@WebServlet("/PostHandler")
public class PostHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostHandler() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    //Flow --> index.html --> web.xml --> Check for Servlet name for the given URL Pattern --> Check for the Servlet Class for the Servlet name  --> Call the Servlet Class with appropriate Method name(doGet/doPost).

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		System.out.println("name="+ name + " --- Address=" + address);
		
		out.println("name="+ name + "<br>Address=" + address);
		out.println("</body></html>");
	}

}
