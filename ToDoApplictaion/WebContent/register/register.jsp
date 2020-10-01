<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Form</title>

</head>
<jsp:include page="../headfoot/header.jsp"></jsp:include>
<body>
	
	<div class="container" style="font-family: cursive; text-align: center;" >
		<label style="font-size: large;">Register
			Form</label>
		<div class="col-md-6 col-md-offset-3">
			<div>
				<p>${NOTIFICATION}</p>
			</div>
			<form action="<%=request.getContextPath()%>/register" method="post">

				<div class="form-group">
					<label for="uname">First Name:</label> <input type="text"
						class="form-control" id="uname" placeholder="First Name"
						name="firstName" required>
				</div>

				<div class="form-group">
					<label for="uname">Last Name:</label> <input type="text"
						class="form-control" id="uname" placeholder="last Name"
						name="lastName" required>
				</div>

				<div class="form-group">
					<label for="uname">User Name:</label> <input type="text"
						class="form-control" id="username" placeholder="User Name"
						name="username" required>
				</div>

				<div class="form-group">
					<label for="uname">Password:</label> <input type="password"
						class="form-control" id="password" placeholder="Password"
						name="password" required>
				</div>

				<button type="submit" class="btn btn-primary">Submit</button>

			</form>
		</div>
	</div>
	

</body>
</html>