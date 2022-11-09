

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {

       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			// Check Login
			UserDataBase dBase = new UserDataBase();
			boolean status = dBase.login(email, password);
			if(!status) {
				request.setAttribute("logged", "false");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			else {
				response.sendRedirect("main.jsp");				// Move to Login Page
			}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}
}
