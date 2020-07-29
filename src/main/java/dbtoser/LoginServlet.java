package dbtoser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

  /*
  
  	The url pattern of this Servlet is given in the web browser as it is the starting point of this application.
  	"get" method is called and is leading to the login.jsp file where it is requesting to give the credentials.
  	On clicking the submit button after filling up the credentials,"Post" method is called and is allowing to go another servlet "display.do" file.
  
   */

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
			response.sendRedirect("/dbtoser/display.do");
			
	}

}