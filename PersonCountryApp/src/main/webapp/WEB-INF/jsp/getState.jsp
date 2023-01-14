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
<title>State Details</title>

<script type="text/javascript" src="/resources/js/validateStudent.js"></script>
<link rel="stylesheet" href="/resources/css/general.css">
<link rel="stylesheet" href="/resources/css/error.css">
</head>

<script type="text/javascript">
	$(function() {
		$('#button').hide();
		$('#collegeId').change(function() {
			this.form.submit();
		});
	});
</script>


<script type="text/javascript">
	
</script>

<body>
	<jsp:include page="header.jsp" />

	<div class="container">

		<h3>State List</h3>

		<p>These details were added successfully</p>

		<br>

		<table class="table table-striped table-bordered">
			<tr>
				<th>State</th>
				<th>Population</th>
				<th>Country</th>
				<th>Options</th>

			</tr>
			<c:forEach items="${stateList}" var="state">
				<tr>
					<td>${state.stateName}</td>
					<td>${state.population}</td>
					<td>${state.countryName}</td>
					<td><a href="/state/editState/${state.stateName}"><button
								type="button" class="btn btn-default btn-sm">
								<span class="glyphicon glyphicon-pencil"></span> Edit
							</button></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>

</html>