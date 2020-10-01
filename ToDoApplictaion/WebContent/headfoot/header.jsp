<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header</title>
</head>
<body style="background-color:linear-gradient(blue,white); font-family: cursive;font-size:large;
  background-image: url('https://envato-shoebox-0.imgix.net/5419/9ea4-885b-4f05-8a81-79e7a26ae481/IMG_3024.jpg?auto=compress%2Cformat&fit=max&mark=https%3A%2F%2Felements-assets.envato.com%2Fstatic%2Fwatermark2.png&markalign=center%2Cmiddle&markalpha=18&w=800&s=d641c0eea00f08d44cce9ae21fc35934');
		height:300px; background-position: center; background-repeat: no-repeat;background-size: cover;color: crimson;">
<header>
 <nav class="navbar navbar-expand-md navbar-dark" style="text-align: center;">
  <div>
   <h1><a class="navbar-brand" style="font-family: cursive;font-size:xx-large;">Task Planner</a></h1>
  </div>

  <ul class="navbar-nav navbar-collapse justify-content-end" style="list-style-type: none;text-align: center;">
   <li><a href="<%= request.getContextPath() %>/login" class="nav-link" >Login</a></li>
   <li><a href="<%= request.getContextPath() %>/register" class="nav-link">Signup</a></li>
  </ul>
 </nav>
</header>
</body>
</html>