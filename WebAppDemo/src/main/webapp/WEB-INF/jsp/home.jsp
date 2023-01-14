<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Management</title>
</head>
<body>


	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="/">
				<button type="button" class="btn btn-primary ">Home</button>
			</a>
		</nav>
		<blockquote class="blockquote text-center">
			<p class="mb-0">Welcome to Employee Data Management</p>
			<a class="btn btn-primary" href="addEmployee" role="button">AddEmployee</a>
			<br> <br> 
			<a class="btn btn-primary" href="getAllEmployees"
				role="button">View Employees</a>
		</blockquote>


	</div>


</body>
</html>