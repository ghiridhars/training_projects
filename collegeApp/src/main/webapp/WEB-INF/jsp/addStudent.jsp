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

<script type="text/javascript" src="/resources/js/validateStudent.js"></script>

<link rel="stylesheet" href="/resources/css/error.css">
<link rel="stylesheet" href="/resources/css/general.css">

<title>Student Form</title>
</head>

<body>
	<div class="container">
		<jsp:include page="header.jsp" />
		<h2>Adding Student Details</h2>
		<form:form name="studentForm" id="studentForm" method="post"
			action="/student/showStudent" modelAttribute="student">

			<div class="form-group">
				<label for="name">Student Name:</label>
				<form:input type="text" class="form-control" id="name"
					placeholder="Name" path="name" name="name"></form:input>
				<form:errors class="validation-error" path="name"></form:errors>
			</div>

			<label for="subject">Student Subject:</label>
			<div class="form-check">
				<form:select class="form-control" name="subject" path="subject"
					id="subject">
					<option value="Arts">Arts</option>
					<option value="Science">Science</option>
					<option value="Others">Others</option>
				</form:select>
				<form:errors class="validation-error" path="subject"></form:errors>
			</div>

			<div class="form-group">
				<label for="age">Student Age:</label> <form:input type="number"
					class="form-control" id="age" path="age" placeholder="Age" name="age"></form:input>
				<form:errors class="validation-error" path="age"></form:errors>
			</div>

			<label for="college">Options for Colleges:</label>
			<div class="form-check">
				<form:select class="form-control" name="collegeId" path="collegeId" id="collegeId">
					<option value=0>----Select---</option>
					<c:forEach items="${collegeList}" var="college">
            			<option value="${college.collegeId}">${college.collegeName}</option>
        			</c:forEach>
				</form:select>
				<form:errors class="validation-error" path="collegeId"></form:errors>
			</div>
			<br>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
		<jsp:include page="footer.jsp" />

	</div>
</body>

</html>