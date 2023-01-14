<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
<!-- Latest compiled JavaScript -->
<!-- jQuery library -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="/resources/js/validateStudent.js"></script>

<link rel="stylesheet" href="/resources/css/home.css">

<script type="text/javascript">
	$(function() {
		$("#submit")
				.on(
						'click',
						function() {
							var className = $("#className").val();
							var subject = [];
							$('input:checkbox:checked').each(function(i) {
								subject[i] = $(this).val();
							});
							console.log(subject);
							$
									.ajax({
										type : 'GET',
										url : '/student/getStudentBy/'
												+ className + '/' + subject,
										result : {},
										dataType : 'json',
										success : function(result) {
											console.log(result);
											var s = '<tr><th>Name</th><th>Gender</th><th>Subjects</th><th>Options</th></tr>';
											for (var i = 0; i < result.length; i++) {
												s += '<tr><td>'
														+ result[i].name
														+ '</td><td>'
														+ result[i].gender
														+ '</td><td>'
														+ result[i].subjects
														+ '</td>'
														+ '<td><a class="text-center" href="/student/editStudent/'
							+result[i].name+'">Edit</a></td></tr>';

											}
											$('#student').html(s);
											console.log(s);
										},
										error : function(result) {
											window.location.href = "/student/error/"
													+ (result.responseText);
										}
									});
						});
	});
</script>

</head>
<body>

	<jsp:include page="header.jsp" />
	<div class="container">
		<h1>Getting FIlter Data</h1>

		<div class="form-group">
			<label>Subjects:</label> <label>Physics</label> <input
				type="checkbox" value="Physics" id="subjects"></input><label>Chemistry</label>
			<input type="checkbox" value="Chemistry" id="subjects" /><label>Mathematics</label>
			<input type="checkbox" value="Mathematics" id="subjects"></input>
		</div>

		<div>
			<label for="className">Class Name:</label> <input type="text"
				class="form-control" id="className" name="className"
				placeholder="Enter Class Name:">
		</div>

		<button type="submit" id="submit" class="btn btn-primary">Submit</button>


		<table id="student" class="table"></table>

	</div>
</html>