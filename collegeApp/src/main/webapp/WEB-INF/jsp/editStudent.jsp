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
<link rel="stylesheet" href="/resources/css/general.css">
<link rel="stylesheet" href="/resources/css/error.css">

<title>Student Form Update</title>
</head>

<body>
	<div class="container">
		<jsp:include page="header.jsp" />
		<h2>Updating Student Details</h2>
		<form:form name="studentForm" id="studentForm" method="post"
			action="/student/showStudent" modelAttribute="student">

			<div class="form-group">
				<label id="studentId" name="studentId" for="name"></label>
				<form:hidden id="studentId" value="${student.studentId}"
					name="studentId" path="studentId"></form:hidden>
			</div>

			<div class="form-group">
				<form:hidden id="name" value="${student.name}"
					name="name" path="name"></form:hidden>
			</div>

			<label for="subject">Student Subject:</label>
			<div class="form-check">
				<form:select class="form-control" value="${student.subject}"
					name="subject" id="subject" path="subject">
					<option value="Arts">Arts</option>
					<option value="Science">Science</option>
					<option value="Others">Others</option>
				</form:select>
			</div>

			<div class="form-group">
				<label for="age">Student Age:</label>
				<form:input type="number" value="${student.age}"
					class="form-control" placeholder="Age" path="age" name="age"
					id="age"></form:input>
			</div>

			<div class="form-check">
				<form:hidden value="${student.collegeId}"
					name="collegeId" id="collegeId" path="collegeId"></form:hidden>
			</div>
			<br>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>

</html>