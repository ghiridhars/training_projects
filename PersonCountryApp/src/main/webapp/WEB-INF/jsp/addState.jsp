<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
	
</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>

<script type="text/javascript" src="/resources/js/validateState.js"></script>
<link rel="stylesheet" href="/resources/css/error.css">
<link rel="stylesheet" href="/resources/css/general.css">

<title>State Form</title>
</head>

<body>
	<jsp:include page="header.jsp" />

	<div class="container">
		<h2>Adding State Details</h2>
		<form name="stateForm" id="stateForm" method="post"
			action="/state/showState" modelAttribute="state">

			<div class="form-group">
				<label for="stateName">State Name:</label> <input type="text"
					class="form-control" id="stateName" placeholder="Name"
					name="stateName"></input>
			</div>

			<div class="form-group">
				<label for="population">Population:</label> <input type="number"
					class="form-control" id="population" placeholder="Population"
					name="population"></input>
			</div>

			<div class="form-group">
				<label for="capital">Capital City:</label> <input type="text"
					class="form-control" id="capital" placeholder="Capital City"
					name="capital"></input>
			</div>

			<label for="country">Options for Country:</label>
			<div class="form-check">
				<select class="form-control" name="countryName" id="countryName" name="countryName">
					<option>----Select---</option>
					<c:forEach items="${countryList}" var="country">
            			<option value="${country.countryName}">${country.countryName}</option>
        			</c:forEach>
				</select>
			</div>
			<br>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<jsp:include page="footer.jsp" />

	</div>
</body>

</html>