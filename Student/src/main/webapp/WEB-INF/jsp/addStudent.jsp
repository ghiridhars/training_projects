<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<script type="text/javascript" src="/resources/js/validateStudent.js"></script>

<link rel="stylesheet" href="/resources/css/error.css">
<link rel="stylesheet" href="/resources/css/home.css">

</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="container">

		<h2>Adding Student Details</h2>

		<form name="studentForm" id="studentForm" method="post"
			action="/student/saveStudent" modelAttribute="student">
			<div>
				<label for="name">Student Name:</label> <input type="text"
					class="form-control" id="name" name="name"
					placeholder="Enter Student Name:">
			</div>

			<div>
				<label for="gender">Gender: </label> <input type="radio"
					name="gender" id="gender" value="female"> <label
					class="form-check-label" for="gender"> Female &nbsp &nbsp</label> <input
					type="radio" name="gender" id="gender" value="male"> <label
					class="form-check-label" for="gender"> Male</label>
			</div>

			<div>
				<label for="className">Class Name:</label> <input type="text"
					class="form-control" id="className" name="className"
					placeholder="Enter Class Name:">
			</div>

			<label for="subject">Subjects: </label>
			<div id="subject">
				<input type="checkbox" value="Physics"
					id="subjects" name="subjects"> <label for="subjects">
					Physics</label> <input type="checkbox" value="Chemistry" id="subjects"
					name="subjects"> <label for="subject"> Chemistry</label> <input
					type="checkbox" value="Mathematics" id="subjects" name="subjects">
				<label for="subjects"> Mathematics</label>
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</html>