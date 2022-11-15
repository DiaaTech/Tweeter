package pkg;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TweetDataBase {

	Connection con;			// Connection Object
	Statement st;			// Statement Object
	
	String url = "jdbc:mysql://localhost:3306/tweeter";
	
	// constructor | Make connection
	public TweetDataBase() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");			// Register Driver
		con = DriverManager.getConnection(url ,"root","851438"); // get Connection
		st = con.createStatement();					// get statement	
	}
	
	// function for reading all the tweets from the DB
	public ArrayList<Tweet> getAllTweets() throws SQLException{
		String query = "select * from tweet";
		
		ResultSet rs = st.executeQuery(query);
		ArrayList<Tweet> tweets = new ArrayList<>();
		
		while(rs.next()) {
			String email = rs.getString(1);
			String name = rs.getString(2);
			String body = rs.getString(3);
			String tags = rs.getString(4);
			int likes = rs.getInt(5);
			String date = rs.getString(6);
			int id = rs.getInt(7);
			
			Tweet newTweet = new Tweet(email, name, body, tags, date, likes, id);
			tweets.add(newTweet);
		}
		
		return tweets;
	}
	
	public void addTweet(Tweet obj) {
		String query = "insert into tweet (email, name, body, tags, likes, date, id) values (?, ?, ?, ?, ?, ?, ?)";
		
		try {
		PreparedStatement pr = con.prepareStatement(query);
		pr.setString(1, obj.getEmail());
		pr.setString(2, obj.getName());
		pr.setString(3, obj.getBody());
		pr.setString(4, obj.getTags());
		pr.setInt(5, obj.getLikes());
		pr.setString(6, obj.getDate());
		pr.setInt(7, obj.getId());
		
		pr.executeUpdate();

		}
		catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	// for counting how many tweets user have done
	public int getTweetsCounts(String email) throws SQLException{
		String query = "select * from tweet where email = ?";
		PreparedStatement pr = con.prepareStatement(query);
		System.out.println(email);
		
		pr.setString(1, email);
		
		ResultSet rs = pr.executeQuery();
		
		int count = 0;
		while(rs.next()) {
			count++;
		}
		
		return count;
	}
	
	// function for reading all the tweets from the DB
		public ArrayList<Tweet> getAllUserTweets(String email) throws SQLException{
			String query = "select * from tweet where email = ?";
			
			PreparedStatement pr = con.prepareStatement(query);

			pr.setString(1, email);
			
			ResultSet rs = pr.executeQuery();
			ArrayList<Tweet> tweets = new ArrayList<>();
			
			while(rs.next()) {
				String name = rs.getString(2);
				String body = rs.getString(3);
				String tags = rs.getString(4);
				int likes = rs.getInt(5);
				String date = rs.getString(6);
				int id = rs.getInt(7);
				
				Tweet newTweet = new Tweet(email, name, body, tags, date, likes, id);
				tweets.add(newTweet);
			}
			
			return tweets;
		}
		

		// function for reading all the tweets from the DB
		public ArrayList<Tweet> getAllSearchTweets(String keyword) throws SQLException{
			String query = "select * from tweet where body like \"%" + keyword + "%\"";
			
			ResultSet rs = st.executeQuery(query);
			ArrayList<Tweet> tweets = new ArrayList<>();
			
			
			while(rs.next()) {
				String email = rs.getString(1);
				String name = rs.getString(2);
				String body = rs.getString(3);
				String tags = rs.getString(4);
				int likes = rs.getInt(5);
				String date = rs.getString(6);
				int id = rs.getInt(7);
				
				Tweet newTweet = new Tweet(email, name, body, tags, date, likes, id);
				tweets.add(newTweet);
			}
			
			return tweets;
		}
		public void deleteTweet(int id) throws SQLException {
			String query = "delete from tweet where id = ?";
			
			PreparedStatement pr = con.prepareStatement(query);
			pr.setInt(1, id);
			
			pr.executeUpdate();			
			
		}
		
		// for counting how many likes the tweet has
		public int getTweetLike(int id) throws SQLException{
			String query = "select * from tweet where id = ?";
			PreparedStatement pr = con.prepareStatement(query);

			
			pr.setInt(1, id);
			
			ResultSet rs = pr.executeQuery();
			
			int count = 0;
			while(rs.next()) {
				return rs.getInt(5);
			}
			
			return 0;
		}
		
		// for updating the tweet likes
		public void updateTweetLikes(int id) throws SQLException {
			String query = "UPDATE tweet SET likes = ? WHERE id = ?";
			int likes = getTweetLike(id);
			likes++;
			
			PreparedStatement pr = con.prepareStatement(query);
			pr.setInt(1, likes);
			pr.setInt(2, id);
			
			pr.executeUpdate();			
			
		}
		
}

