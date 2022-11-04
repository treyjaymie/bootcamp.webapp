

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Logger;




public class ServletA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private static final Logger LOGGER = LogManager.getLogger(ServletA.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("action+do_get, source=servlet_a");
		
		final ServletConext context = getServletContext();
		context.setAttribute(getServletName(), "John Doe");
		
		request.setAttribute("email", "johndoe@gmail.com");
		
		response.sendRedirect("./b");
		// redirect is designed to able to move from one domain to another, a different context
	}

}
/*
 * application context => attributes/data most likely not to change
 * 						global, data that maintains and is binded to the application
 * 						attributes stays only until the lifetime of the application
 * 
 */
/*