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
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="/resources/js/validateStudent.js"></script>
<link rel="stylesheet" href="/resources/css/general.css">
<link rel="stylesheet" href="/resources/css/error.css">

<title>State Form Update</title>
</head>

<body>
	<div class="container">
		<jsp:include page="header.jsp" />
		<h2>Updating State Details</h2>
		<form:form name="stateForm" id="stateForm" method="post"
			action="/state/saveState" modelAttribute="state">

			<div class="form-group">
				<label id="stateId" name="studentId" for="name"></label>
				<form:hidden id="stateId" value="${state.stateId}"
					name="stateId" path="stateId"></form:hidden>
			</div>

			<div class="form-group">
				<form:hidden class="form-control" id="stateName" value="${state.stateName}"
					name="stateName" path="stateName"></form:hidden>
			</div>


			<div class="form-group">
				<label for="population">Population:</label>
				<form:input type="number" value="${state.population}"
					class="form-control" placeholder="Age" path="population" name="population"
					id="population"></form:input>
			</div>

			<div class="form-group">
				<form:hidden class="form-control" id="countryName" value="${state.countryName}"
					name="countryName" path="countryName"></form:hidden>
			</div>
			<br>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>

</html>