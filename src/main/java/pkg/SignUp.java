package pkg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("name");
		String password = request.getParameter("password");
		String cnpassword = request.getParameter("cnpassword");
		
		// Compare Passwords
		if(!password.equals(cnpassword)) {
			System.out.print("Equal");
			request.setAttribute("error", "true");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		try {
			// Check Login
			UserDataBase dBase = new UserDataBase();
			boolean status = dBase.signUp(email, password);
			if(!status) {
				System.out.print("Already Log");
				request.setAttribute("logged", "true");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			else {
				response.sendRedirect("takeData.jsp");				// Move to Login Page
				HttpSession session = request.getSession(true);
				session.setAttribute("email", email);
			}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}
}
