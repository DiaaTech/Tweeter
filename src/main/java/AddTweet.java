

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.realm.UserDatabaseRealm;

import pkg.Tweet;
import pkg.TweetDataBase;
import pkg.UserDataBase;

/**
 * Servlet implementation class AddTweet
 */
@WebServlet("/addTweet")
public class AddTweet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		
			// Get Session
			HttpSession session = request.getSession(false);
			String email = (String) session.getAttribute("email"); 
			
			// Get Parameters
			String body = request.getParameter("body");
			String tags = request.getParameter("tags");
			int likes = 0;
			
			// Name of person from DataBase against it's Email
			UserDataBase dBase = new UserDataBase();
			String name = dBase.getName(email);
			
			
			// generate Date
			 long millis=System.currentTimeMillis();  
		      
			// creating a new object of the class Date  
			java.sql.Date date = new java.sql.Date(millis);  
			
			int id =  (int) (Math.random()*(10000000-1000+1)+1000);   
			
			
			Tweet obj = new Tweet(email, name, body, tags, date.toString(), likes, id);
			TweetDataBase dBase2 = new TweetDataBase();
			System.out.println(name + email + body + tags+ date);
			
			dBase2.addTweet(obj);
			
			response.sendRedirect("main.jsp");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
