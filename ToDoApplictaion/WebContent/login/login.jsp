<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Planner Login Form</title>

</head>
<body>


	<jsp:include page="../headfoot/header.jsp"></jsp:include>
	<div class="container col-md-8 col-md-offset-3"
		style="overflow: auto; font-family: cursive; text-align: center;">
		
		<h1>User Login</h1>

		<form action="<%=request.getContextPath()%>/login" method="post">
			
				<div class="form-group">
					<label for="uname">User Name:  </label> <input type="text"
						class="form-control" id="username" placeholder="User Name"
						name="username" required>
				</div>
			
			
				<div class="form-group">
					<label for="uname">Password:  </label> <input type="password"
						class="form-control" id="password" placeholder="Password"
						name="password" required>
				</div>

			
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

</body>
</html>