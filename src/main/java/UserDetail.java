

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.w3c.dom.html.HTMLImageElement;

@WebServlet("/UserDetail")
public class UserDetail extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		String name = request.getParameter("name");
		String image = request.getParameter("image");
		String bio = request.getParameter("bio");
		String location = request.getParameter("location");
		String email = (String) session.getAttribute("email");
		
		User user = new User(email, name, bio, location, "", image);
		
		try {
			UserDataBase dBase = new UserDataBase();
			boolean check = dBase.insertUser(user);
			if(check) {
				response.sendRedirect("main.jsp");
			}
			else {
				response.sendRedirect("takeData.jsp");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
