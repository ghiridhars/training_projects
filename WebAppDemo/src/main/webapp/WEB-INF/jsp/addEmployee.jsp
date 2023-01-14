<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<script type="text/javascript" src="/resources/js/validate.js" ></script>

<link rel="stylesheet" href="/resources/css/style.css">

<title>Employee Form</title>

</head>

<body>
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="/Employee/">
				<button type="button" class="btn btn-primary ">Employee
					Home</button>
			</a>
		</nav>
		<h2>Adding Employee Details</h2>
		<form name="form1" id="form1" method="post" action="showEmployee"
			modelAttribute="employee">
			<div class="form-group">
				<label for="name">Employee Name:</label> <input type="text"
					class="form-control" id="name" name="name"></input>
			</div>
			<div class="form-group">
				<label for="desig">Employee Designation</label> <input type="text"
					class="form-control" id="designation" placeholder="Designation"
					name="designation">
			</div>
			<div class="form-group">
				<label for="pwd">Employee Salary</label> <input type="number"
					class="form-control" id="salary" placeholder="salary" name="salary">
			</div>
			<div class="form-group">
				<input class="form-check-input" name="gender" type="radio"
					value="male" id="gender"> <label class="form-check-label"
					for="male"> Male </label> <input class="form-check-input"
					name="gender" type="radio" value="female" id="gender"> <label
					class="form-check-label" for="female"> Female </label> <input
					class="form-check-input" name="gender" type="radio" value="other"
					id="gender"> <label class="form-check-label" for="other">Other</label>
			</div>

			<div class="form-check" name="checkHobby" id="checkHobby">
				<input class="form-check-input" type="checkbox" name="hobbies[]" value="read" id="read_check" onclick="validateCheck()">
				<label class="form-check-label" for="read_check"> Read</label>
				<input class="form-check-input" type="checkbox" name="hobbies[]" value="cycle" id="cycle_check" onclick="validateCheck()">					
				<label class="form-check-label" for="cycle_check">Cycle</label>
				<input class="form-check-input" type="checkbox" name="hobbies[]" value="dance" id="dance_check" onclick="validateCheck()">
				<label class="form-check-label" for="dance_check"> Dance</label>
				<input class="form-check-input" type="checkbox" name="hobbies[]" value="sing" id="sing_check" onclick="validateCheck()">
				<label class="form-check-label" for="sing_check"> Sing </label>
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>

</html>