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

		<form>
			<div class="form-group">
				<label for="writerName">Writer Name:</label> <input type="text"
					class="form-control" id="writerName"
					placeholder="Enter Writer Name:">
			</div>

			<select class="form-control" name="bookId" id="bookId">
				<option value=0>----Select---</option>
				<c:forEach items="${bookList}" var="book">
            			<option value="${book.bookId}">${book.bookName}</option>
        			</c:forEach>
			</select>


			<button type="submit">Submit</button>
		</form>


		<jsp:include page="footer.jsp" />
	</div>

</body>
</html>