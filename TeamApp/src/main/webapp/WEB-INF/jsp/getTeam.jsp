<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">	
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<!-- Latest compiled JavaScript -->
<!-- jQuery library -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/css/general.css">

</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<h3>Team List</h3>

		<p>These details were added successfully</p>

		<table class="table table-striped table-bordered">
			<tr>
				<th>Id</th>
				<th>Team Name</th>
				<th>Maximum Player Limit</th>
			</tr>
			<c:forEach items="${teamList}" var="team">
				<tr>
					<td>${team.id}</td>
					<td>${team.teamName }</td>
					<td>${team.maxLimit}</td>
				</tr>
			</c:forEach>
		</table>

	</div>



</body>
</html>