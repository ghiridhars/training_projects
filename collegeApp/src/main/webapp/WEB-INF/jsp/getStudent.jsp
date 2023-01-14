<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Details</title>

<link rel="stylesheet" href="/resources/css/general.css">
<link rel="stylesheet" href="/resources/css/error.css">
</head>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#collegeId')
								.on(
										'change',
										function() {
											var id = $(this).val();
											console.log(id);
											$
													.ajax({
														type : 'GET',
														url : '/student/getStudent/'
																+ id,
														data : {},
														dataType : 'json',
														success : function(data) {
															console.log(data);
															var s = '<tr><th>Name</th><th>Subject</th><th>Age</th><th>Options</th></tr>';
															for (var i = 0; i < data.length; i++) {
																s += '<tr><td>'
																		+ data[i].name
																		+ '</td><td>'
																		+ data[i].subject
																		+ '</td><td>'
																		+ data[i].age
																		+ '</td><td><a href="/student/editStudent/'+data[i].studentId+'">Edit</a></td></tr>';
															}
															console.log(s);
															$('#student').html(
																	s);
														}
													});
										});

					});
</script>


<script type="text/javascript">
	
</script>

<body>
	<div class="container">
		<jsp:include page="header.jsp" />

		<h3>Student List</h3>

		<p>These details were added successfully</p>

		<form name="form1" id="form1" method="post" action="showStudents">
			<label for="college">Filter By College:</label>
			<div class="form-check">
				<select class="form-control" name="collegeId" id="collegeId">
					<option value=0>----Select---</option>
					<c:forEach items="${collegeList}" var="college">
						<option value="${college.collegeId}">${college.collegeName}</option>
					</c:forEach>
				</select>
			</div>
		</form>

		<br>

		<table id="student" class="table table-striped table-bordered">
		</table>
	</div>
</body>

</html>