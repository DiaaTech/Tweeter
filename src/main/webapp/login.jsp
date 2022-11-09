<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Tweeter</title>
    <link rel="stylesheet" href="css/signup.css" />
  </head>
  <body>
    <div class="main">
      <!-- Navigation -->
      <nav>
        <h1>Tweeter</h1>
        <ul>
          <li><a href="login.jsp">Home</a></li>
          <li><a href="about-us.jsp">About Us</a></li>
          <li><a href="contact-us.jsp">Contact Us</a></li>
          <li><a href="login.jsp">Login</a></li>
        </ul>
      </nav>

      <!-- Form -->
      <div class="signup">
        <h2>Login to Tweeter</h2>
        <form action = "Login" method = "POST">
          <input type="email" placeholder="Email" name = "email"/>
          <input type="text" placeholder="Password" name = "password"/>
          
           <%
                if( request.getAttribute("logged") == "false"){
            %>
           		<p style = "color:white; margin:0; font-size:18px;">
         			Credentials are Invalid
         	   </p>
            <%
                }

            %>
          
          <input type="submit" class="btn" value="Login" />
        </form>
      </div>
    </div>
  </body>
</html>
