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
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<link rel="stylesheet" href="/resources/css/error.css">
<link rel="stylesheet" href="/resources/css/general.css">

<script type="text/javascript">
	$(document).ready(function() {
		$('#countryName').on('change', function() {
			var country = $(this).val();
			console.log(country);
			$.ajax({
				type : 'GET',
				url : '/person/getStatesByCountry/' + country,
				data:{},
				dataType:'json',
				success : function(data) {
					console.log(data);
					var s = '<option>----</option>';
					for (var i = 0; i < data.length; i++) {
						s += '<option value="' + data[i]+ '">'+ data[i]+'</option>';
					}
					console.log(s);
					$('#stateName').html(s);
				}
			});
		});

		
		$('#stateName').on('change', function() {
			var state = $(this).val();
			$.ajax({
				type : 'GET',
				result : {},
				dataType : 'json',
				url : '/person/getPersonsByState/' + state,
				success : function(result) {
					console.log(result);
					var s = '<tr><th>Name</th><th>Hobbies</th><th>Gender</th></tr>';
					for (var i = 0; i < result.length; i++) {
						s += '<tr><td>'+ result[i].name+'</td><td>'+ result[i].hobbies+'</td><td>' + result[i].gender+'</td></tr>';
					}
					console.log(s);
					$('#person').html(s);
				}
			});
		});

	});
</script>

<title>All Data</title>
</head>

<body>
	<jsp:include page="header.jsp" />

	<div class="container">
		<h2>All Person Details</h2>
		<form name="personForm" id="personForm" method="post"
			action="/person/showPerson" modelAttribute="person">

			<label for="country">Options for Country:</label>
			<div class="form-check">
				<select class="form-control" name="countryName" id="countryName">
					<option value=0>----Select---</option>
					<c:forEach items="${countryList}" var="country">
            			<option value="${country.countryName}">${country.countryName}</option>
        			</c:forEach>
				</select>
			</div>
			<br>
			<label for="state">Options for State:</label>
			<div class="form-check">
				<select id="stateName" class="form-control" style="width: 200px"></select>
			</div>	

			<table id="person" class="table table-striped table-bordered"></table>

		</form>
		<jsp:include page="footer.jsp" />

	</div>
</body>

</html>