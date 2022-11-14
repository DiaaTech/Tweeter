<!DOCTYPE html>
<%@page import = "pkg.TweetDataBase"%>
<%@page import = "pkg.Tweet"%>
<%@page import="java.util.ArrayList"%>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Tweeter | Home</title>
    <link rel="stylesheet" href="css/main.css" />

    <script
      src="https://kit.fontawesome.com/853558b03f.js"
      crossorigin="anonymous"
    ></script>
  </head>
  <body>
    <nav>
      <h1>Tweeter</h1>
      <form class="search">
        <input type="text" placeholder="Search" />
        <button type="submit">
          <i class="fa-solid fa-magnifying-glass fa-2x"></i>
        </button>
      </form>
      <div class="profile">
        <a href="profile.jsp"><i class="fa-solid fa-user fa-2x"></i></a>
      </div>
    </nav>

    <!-- Main Page for Tweets-->
    <div class="container">
      <!-- Header -->
      <div class="header">
        <h2>All Tweets</h2>
        <div class="post">
          <a href="addTweet.jsp"><i class="fa-solid fa-arrow-up fa-2x"></i></a>
          <p>Add Your Tweet</p>
        </div>
      </div>

      <!-- Tweet (Email, Name, Body, Tags, Likes, Date) -->
      <div class="tweets">

	<%
	try{
		TweetDataBase db = new TweetDataBase();
    	ArrayList<Tweet> tweets = db.getAllTweets();
    	if(tweets.size() == 0){
    		
	%>
		<h1>No Tweets Found</h1>	
	
	<%
    	}
    	else{
    		for(int i = 0; i<tweets.size(); i++){
	%>

       <!-- Tweet -->
        <div class="tweet">
          <!-- Person -->
          <div class="person">
            <p class="name">@ 
            <% out.print(tweets.get(i).getName()); %>
            </p>
            <p class="email"><% out.print(tweets.get(i).getEmail()); %></p>
          </div>
          <!-- Body -->
          <div class="body">
          <% out.print(tweets.get(i).getBody()); %>
          </div>
          <div class="footer">
          <div class="date">
            <button><i class="fa-regular fa-clock"></i></i></button>
            <p><% out.print(tweets.get(i).getDate()); %></p>
          </div>
          <!-- Likes -->
          <div class="likes">
            <button><i class="fa-regular fa-thumbs-up fa-2x"></i></button
            ><span><% out.print(tweets.get(i).getLikes()); %> Likes</span>
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
