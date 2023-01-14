<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
			</script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js">
			</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Log In</title>
</head>
<body>
	<div class="container">
		<h2>Login</h2>
		<form method="post" action="checkUser" modelAttribute="user">
			<div class="form-group">
				<label for="Username">Username</label>
				<input type="text" class="form-control" name="name" id="username" placeholder="Enter username">
			</div>
			<div class="form-group">
				<label for="Password">Password</label>
				<input type="password" class="form-control" name="password" id="password" placeholder="Password">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>