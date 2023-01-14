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
<title>Country Details</title>
<link rel="stylesheet" href="/resources/css/general.css">

</head>

<body>

	<jsp:include page="header.jsp" />

	<div class="container">
		<h3>College List</h3>

		<p>These details were added successfully</p>

		<table class="table table-striped table-bordered">
			<tr>
				<th>Country Name</th>
				<th>Country Type</th>
			</tr>
			<c:forEach items="${countryList}" var="country">
				<tr>
					<td>${country.countryName }</td>
					<td>${country.countryType}</td>
				</tr>
			</c:forEach>
		</table>

	</div>


</body>

</html>