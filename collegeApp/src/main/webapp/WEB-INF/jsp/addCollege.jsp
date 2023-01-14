<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
	
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<script type="text/javascript" src="/resources/js/validateCollege.js"></script>

<title>College Form</title>
<link rel="stylesheet" href="/resources/css/general.css">
<link rel="stylesheet" href="/resources/css/error.css">
</head>

<body>
	<div class="container">
		<jsp:include page="header.jsp" />

		<h2>Adding College Details</h2>
		<form:form id="collegeForm" method="post"
			action="showCollege" modelAttribute="college">
			<div class="form-group">
				<label for="name">College Name:</label> <form:input type="text"
					class="form-control" placeholder="Enter College Name"
					id="collegeName" name="collegeName" path="collegeName"></form:input>
				<form:errors class="validation-error" path="collegeName"></form:errors>
			</div>
			<div class="form-group">
				<label for="strength">College Strength</label> <form:input type="number"
					class="form-control" id="strength" placeholder="Enter Strength"
					name="strength" path="strength"></form:input>
				<form:errors class="validation-error" path="strength"></form:errors>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
		<jsp:include page="footer.jsp" />

	</div>
</body>

</html>