package com.simplilearn.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieve all the cookies from the request object.
		Cookie cookie = null;
		Cookie[] cookies = null;
		boolean found = false;
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		cookies = request.getCookies(); // This method will list all the Cookies that the server got from the Browser.
		
		//Check if we have our userid cookie stored in Browser or not.
		if(cookies!=null)
		{
			for(int i=0;i< cookies.length;i++)
			{
				cookie = cookies[i]; // Take One Cookie at a time.
				if(cookie.getName().contentEquals("userid") && cookie.getValue()!=null)
				{
					out.println("Session Found: Userid read from cookie: "+cookie.getValue() + "<br>");
					found  = true;
				}
			}
			
			//Now, all the Cookies are checked.
			if(!found)
			{
				out.println("No Session Found: No UserId was found in cookie. <br>");
			}
			out.println("</body></html>");
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
