<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="pkg.TweetDataBase"%>
<%@page import = "pkg.UserDataBase"%>
<%@page import = "pkg.Tweet"%>
<%@page import = "pkg.User"%>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Profile</title>
    <link rel="stylesheet" href="css/profile.css" />

    <script
      src="https://kit.fontawesome.com/853558b03f.js"
      crossorigin="anonymous"
    ></script>
  </head>
  <body>
    <nav>
      <h1><a href = "main.jsp">Tweeter</a></h1>
      <button>LogOut</button>
    </nav>

<% 
	try{

		UserDataBase db = new UserDataBase();
		
		String email = (String) session.getAttribute("email"); 
			
		User user = db.getUser(email);
		TweetDataBase dbTweeter = new TweetDataBase();
		int count = dbTweeter.getTweetsCounts(email);
		String filePath = request.getServletContext().getRealPath("/" + "images/" )+ user.getImage();
		
		System.out.println(filePath);
%>
    <!-- User (Email, Name, Bio, Picture, Location, DOJ)  -->
    <div class="person">
   
      <div class="image">
        <img src="<% out.print(filePath); %>" alt="Profile Picture" />
      </div>
      <h2>
      	<% out.print(user.getName()); %>     	
	  </h2>
      <p class="bio">A FUll Stack Developer</p>
      <div class="location">
        <button><i class="fa-solid fa-location-dot fa-2x"></i></button>
        <p><% out.print(user.getLocation()); %>  </p>
      </div>
      <p>Since: <% out.print(user.getDate()); %> </p>
    </div>
    <div class="stats">

        <button><% out.print(count); %> Tweets</button>
        <button>12 Followers</button>
        <button>13 Followings</button>
    </div>

    <div class="container">
        <h1>Your Tweets</h1>
     <!-- Tweet (Email, Name, Body, Tags, Likes, Date) -->
      <div class="tweets">
        <!-- Tweet -->
 
 		<%       
        	ArrayList<Tweet> tweets = dbTweeter.getAllUserTweets(email);
 			if(tweets.size() == 0){
        %>
        <h1>No Tweets Found</h1>
        <%
 			}
        else{
        	for(int i = 0; i<tweets.size(); i++){
        %>
        <div class="tweet">
  
          <!-- Body -->
          <div class="body">
           <% out.print(tweets.get(i).getBody()); %>
          </div>
          <div class="footer">
          <div class="date">

            <button><i class="fa-regular fa-clock"></i></i></button>
            <p>   <% out.print(tweets.get(i).getDate()); %></p>
          </div>
          <!-- Likes -->
          <div class="likes">
            <button class="delete"><i class="fa-solid fa-trash fa-2x"></i></button>
            <button><i class="fa-regular fa-thumbs-up fa-2x"></i></button
            ><span>   <% out.print(tweets.get(i).getLikes()); %> Likes</span>
          </div>
        </div>
        </div>
        
        <%
			}}}
			catch(Exception e){
				e.printStackTrace();
			}
		%>

 </div>
            



   
  </body>
</html>
