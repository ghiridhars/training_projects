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
<title>Ajax Example</title>

<script type="text/javascript">
$(document).ready(function(){

	$('#designation').on('change', function(){
		var designation= $(this).val();
		$.ajax({
			type: 'GET',
			url: '/Employee/getEmployeeByDesignation/' + designation,
			success: function(result) {
				var result = JSON.parse(result);
				var s = '<tr><th>Id</th><th>Name</th><th>Salary</th></tr>';
				for(var i = 0; i < result.length; i++) {
					s += '<tr><th>'+result[i].id+'</th><th>'+result[i].name+'</th><th>'
					+result[i].salary+'</th></tr>';
				}
				console.log(s);				
				$('#employee').html(s);
			}
		});
	});
});
</script>

</head>
<body>

	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="/">
				<button type="button" class="btn btn-primary ">Home</button>
			</a>
			<div class="navbar-header">
				<h3 class="text-center">Employee Management</h3>
			</div>
		</nav>
		<h3>Employee List</h3>

		<form name="form1" id="form1" method="post" action="showStudents">
			<label for="college">Filter By Designation:</label>
			<div class="form-check">
				<select class="form-control" name="designation" id="designation">
					<option value=0>----Select---</option>
					<c:forEach items="${designation}" var="desig">
						<option value="${desig}">${desig}</option>
					</c:forEach>
				</select>
			</div>
		</form>

		<br>

		<table id="employee" class="table table-striped table-bordered">

		</table>
	</div>

</body>
</html>