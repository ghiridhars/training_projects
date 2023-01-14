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
<!-- Latest compiled JavaScript -->
<!-- jQuery library -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

</head>
<link rel="stylesheet" href="/resources/css/general.css">

<script src="/resources/js/validateTeam.js"></script>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<h2>Adding Team Details</h2>
		<form name="teamForm" id="teamForm" method="post" action="showTeam"
			modelAttribute="team">
			<div class="form-group">
				<label for="teamName">Team Name:</label> <input type="text"
					class="form-control" placeholder="Enter Team Name" id="teamName"
					name="teamName"></input>
			</div>
			<div class="form-group">
				<label for="strength">Maximum Player Strength</label> <input
					type="number" class="form-control" id="maxLimit"
					placeholder="Enter Player Limit" name="maxLimit">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>



</body>
</html>