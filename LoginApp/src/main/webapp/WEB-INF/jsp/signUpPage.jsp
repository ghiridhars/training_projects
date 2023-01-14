<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<element>
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
<title>User Sign Up</title>
</head>
</element>
<body>
	<div class="container">
		<h2>Sign Up</h2>
		<form action="enterUser" modelAttribute="user">
			<div class="form-group">
				<label for="Email">Email address</label>
				<input type="email" class="form-control" id="email" name="emailId" placeholder="Enter email">
			</div>
			<div class="form-group">
				<label for="ContactNo">Contact No</label>
				<input type="number" class="form-control" id="contactNo" name="contactNo" placeholder="Enter Contact No">
			</div>
			<div class="form-group">
				<label for="username">UserName</label>
				<input type="text" class="form-control" id="username" name="name" placeholder="Enter username">
			</div>
			<div class="form-group">
				<label for="password">Password</label>
				<input type="password" class="form-control" id="password" name="password" placeholder="Password">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>