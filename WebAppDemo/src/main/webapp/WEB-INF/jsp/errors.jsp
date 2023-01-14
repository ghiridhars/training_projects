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
<title>Employee Home</title>
</head>
<body>


	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="/Employee/">
				<button type="button" class="btn btn-primary ">Employee
					Home</button>
			</a>
		</nav>
		<div class="alert alert-danger" role="alert">Error(s)
			Encountered!</div>
		<table class="table table-striped table-bordered">
			<tr>
				<th>Error details</th>
			</tr>
			<c:forEach items="${errors}" var="error">
				<tr>
					<td>${error}</td>
				</tr>
			</c:forEach>
		</table>

		<h5>${message}</h5>
	</div>


</body>
</html>