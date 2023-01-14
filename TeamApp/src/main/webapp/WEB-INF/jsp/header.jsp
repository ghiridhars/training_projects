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
<link rel="stylesheet" href="/resources/css/header.css">
</head>
<body>

	<nav class="navbar">
		<a href="/">Home</a>

		<ul>
			<li><a href="">Team Data</a>
				<div class="row">
					<div class="col">
						<a href="/team/addTeam">Add Team</a>
					</div>
					<div class="col">
						<a href="/team/getAllTeam">Get Team</a>
					</div>
				</div></li>

			<li><a href="">Player Data</a>
				<div class="row">
					<div class="col">
						<a href="/player/addPlayer">Add Player</a>
					</div>
					<div class="col">
						<a href="/player/getAllPlayers">Get Players</a>
					</div>
				</div></li>
			<li><a href="/logout">Log out</a>
		</ul>


	</nav>


</body>
</html>