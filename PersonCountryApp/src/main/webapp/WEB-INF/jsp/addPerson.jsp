<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="/resources/js/validate.js" ></script>
	

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

		
	});
</script>

<title>Person Form</title>
</head>

<body>
	<jsp:include page="header.jsp" />

	<div class="container">
		<h2>Adding Person Details</h2>
		<form name="personForm" id="personForm" method="post"
			action="/person/showPerson" modelAttribute="person">

			<div class="form-group">
				<label for="name">Person Name:</label> <input type="text"
					class="form-control" id="name" placeholder="Name" name="name"></input>
			</div>

			<div class="form-group">
				<label> Gender:</label> <input class="form-check-input"
					name="gender" type="radio" value="male" id="gender"> <label
					class="form-check-label" for="male"> Male </label> <input
					class="form-check-input" name="gender" type="radio" value="female"
					id="gender"> <label class="form-check-label" for="female">
					Female </label> <input class="form-check-input" name="gender" type="radio"
					value="other" id="gender"> <label class="form-check-label"
					for="other">Other</label>
			</div>

			<div class="form-check" name="checkHobby" id="checkHobby">
				<label> Hobbies:</label><br> <input class="form-check-input"
					type="checkbox" name="hobbies[]" value="read" id="read_check">
				<label class="form-check-label" for="read_check"> Read</label> <input
					class="form-check-input" type="checkbox" name="hobbies[]"
					value="cycle" id="cycle_check"><label
					class="form-check-label" for="cycle_check">Cycle</label> <input
					class="form-check-input" type="checkbox" name="hobbies[]"
					value="dance" id="dance_check"> <label
					class="form-check-label" for="dance_check"> Dance</label> <input
					class="form-check-input" type="checkbox" name="hobbies[]"
					value="sing" id="sing_check"> <label
					class="form-check-label" for="sing_check"> Sing </label>
			</div>

			<label for="country">Options for Country:</label>
			<div class="form-check">
				<select class="form-control" name="countryName" id="countryName">
					<option>----Select---</option>
					<c:forEach items="${countryList}" var="country">
						<option value="${country.countryName}">${country.countryName}</option>
					</c:forEach>
				</select>
			</div>
			
			<br> <label for="state">Options for State:</label>
			<div class="form-check">
				<select class="form-control" id="stateName" name="stateName" ></select>
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<jsp:include page="footer.jsp" />

	</div>
</body>

</html>