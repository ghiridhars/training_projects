<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
	
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>College Details</title>
<link rel="stylesheet" href="/resources/css/general.css">

</head>

<body>


	<div class="container">
		<jsp:include page="header.jsp" />
		<h3>College List</h3>

		<p>These details were added successfully</p>

		<table class="table table-striped table-bordered">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Strength</th>
			</tr>
			<c:forEach items="${collegeList}" var="college">
				<tr>
					<td>${college.collegeId}</td>
					<td>${college.collegeName }</td>
					<td>${college.strength}</td>
				</tr>
			</c:forEach>
		</table>

	</div>


</body>

</html>