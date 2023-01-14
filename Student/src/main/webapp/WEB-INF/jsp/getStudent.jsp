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
	
<link rel="stylesheet" href="/resources/css/home.css">
	
<script type="text/javascript">
	$(function() {
		$("#className").on('change', function() {
			var name = $(this).val();
			$.ajax({
				type : 'GET',
				url : '/student/getStudent/' + name,
				result : {},
				dataType : 'json',
				success : function(result) {
					var s = '<tr><th>Name</th><th>Gender</th><th>Subjects</th><th>Options</th></tr>';
					for(var i = 0;i<result.length;i++){
						if(result[i].subjects.length != 0){
							s+='<tr><td>'+result[i].name+'</td><td>'+result[i].gender+'</td><td>'
							+result[i].subjects+'</td>'+'<td><a class="text-center" href="/student/editStudent/'
							+result[i].name+'">Edit</a></td></tr>';
							}
					}
					$('#student').html(s);
					console.log(s);
				}
			});
		});
	});
</script>

</head>
<body>

	<jsp:include page="header.jsp" />
	<div class="container">
		<h1>Getting Data</h1>
		<form name="studentForm" id="studentForm" method="post"
			action="/student/showStudent" modelAttribute="student">

			<label for="class">Options for Class:</label>
			<div>
				<select class="form-control" name="className" id="className">
					<option>----Select---</option>
					<c:forEach items="${classList}" var="class">
������������			<option value="${class}">${class}</option>
��������			</c:forEach>
				</select>
			</div>

			<table id="student" class="table"></table>

		</form>
	</div></html>