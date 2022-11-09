import java.sql.*;
import java.util.ArrayList;

public class UserDataBase {
	
	Connection con;			// Connection Object
	Statement st;			// Statement Object
	
	String url = "jdbc:mysql://localhost:3306/tweeter";
	
	// constructor | Make connection
	UserDataBase() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");			// Register Driver
		con = DriverManager.getConnection(url ,"root","851438"); // get Connection
		st = con.createStatement();					// get statement	
	}
	
	
	// Function for searching if user already exists or not

	public boolean searchUser(String email) throws SQLException {
		String queryString = "select * from login where email = ?";
		
		PreparedStatement pr = con.prepareStatement(queryString);
		pr.setString(1, email);
		ResultSet rSet = pr.executeQuery();
		if(rSet.next()) {
			return true;
		}
		return false;
		
	}
	// function for checking the credentials during login
	public boolean login(String email, String password) throws Exception {
		String queryString = "select * from login where email = ? and password = ?";
		
		PreparedStatement pr = con.prepareStatement(queryString);
		pr.setString(1, email);
		pr.setString(2, password);
		
		ResultSet rSet = pr.executeQuery();
		
		if(rSet.next()) {
			return true;
		}
		return false;
	}
	
	// function for checking the signUp
	public boolean signUp(String email, String password) throws Exception {
		// if person is already existing and doing sign up again	
		if(searchUser(email)) {
			return false;
		}
		String query = "insert into login (email, password) values (?, ?)";

		PreparedStatement pr = con.prepareStatement(query);
		pr.setString(1, email);
		pr.setString(2, password);
		
		pr.executeUpdate();
		return true;
	}
	
	// Insertion FUnction for our User
	public boolean insertUser(User user) {
			String query = "insert into user (email, name, bio, location, dateOfJoin, picture) values (?, ?, ?, ?, ?, ?)";
			
			try {
			PreparedStatement pr = con.prepareStatement(query);
			pr.setString(1, user.getEmail());
			pr.setString(2, user.getName());
			pr.setString(3, user.getBio());
			pr.setString(4, user.getLocation());
			
			// generate Date
			 long millis=System.currentTimeMillis();  
		      
			// creating a new object of the class Date  
			java.sql.Date date = new java.sql.Date(millis);  
			pr.setString(5, date.toString());
			pr.setString(6, user.getImage());
			pr.executeUpdate();
			return true;
			}
			catch (Exception e) {
				return false;
			}
	}
}
