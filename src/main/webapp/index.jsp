
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
          <li><a href="index.jsp">Home</a></li>
          <li><a href="about-us.jsp">About Us</a></li>
          <li><a href="contact-us.jsp">Contact Us</a></li>
          <li><a href="login.jsp">Login</a></li>
        </ul>
      </nav>

      <!-- Form -->
      <div class="signup">
        <h2>Sign up to join our community</h2>
        <form action = "SignUp" method = "POST">
          <input type="email" placeholder="Email" name = "name" />
          <input type="text" placeholder="Password" name = "password"/>
          <input type="text" placeholder="Confirm Password" name = "cnpassword" />
              
            <%
                if( request.getAttribute("error") == "true"){
            %>
           		<p style = "color:white; margin:0; font-size:18px;">
         			Password did not match
         	   </p>
            <%
                }

            %>
            
              <%
                if( request.getAttribute("logged") == "true"){
            %>
           		<p style = "color:white; margin:0; font-size:18px;">
         			Already Have Account. Log In.
         	   </p>
            <%
                }

            %>
            

          <input type="submit" class="btn" value="Sign Up" />
    
         
          
        </form>
      </div>
    </div>
  </body>
</html>
