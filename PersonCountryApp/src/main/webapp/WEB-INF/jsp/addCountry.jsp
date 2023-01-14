<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<!-- Latest compiled JavaScript -->
<!-- jQuery library -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<title>Country Form</title>

<script type="text/javascript" src="/resources/js/validateCountry.js"></script>

<link rel="stylesheet" href="/resources/css/general.css">
<link rel="stylesheet" href="/resources/css/error.css">
</head>

<body>
	<jsp:include page="header.jsp" />

	<div class="container">

		<h2>Adding Country Details</h2>
		<form name="countryForm" id="countryForm" method="post"
			action="showCountry" modelAttribute="country">
			<div class="form-group">
				<label for="name">Country Name:</label> <input type="text"
					class="form-control" placeholder="Enter Country Name"
					id="countryName" name="countryName"></input>
			</div>
			<div class="form-group">
				<p>
					<label for="type">Type:</label>
				</p>
				<input class="form-check-input" name="countryType" type="radio"
					value="asian" id="countryType"> <label
					class="form-check-label" for="asian">Asian</label> <input
					class="form-check-input" name="countryType" type="radio"
					value="non-asian" id="countryType"> <label
					class="form-check-label" for="non-asian">Non-asian</label>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<jsp:include page="footer.jsp" />

	</div>
</body>

</html>