<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Get Books</title>
</head>
<body>

	<div class="container">
		<jsp:include page="header.jsp" />


		<table class="table table-striped table-bordered">
			<tr>
				<th>Writer ID</th>
				<th>Writer Name</th>
				<th>Book</th>
			</tr>

			<c:forEach items="${writers}" var="writer">
				<tr>
					<td>${writer.writerId}</td>
					<td>${writer.writerName}</td>
					<td>${writer.book}</td>
				</tr>
			</c:forEach>

		</table>


		<jsp:include page="footer.jsp" />

	</div>

</body>
</html>