<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

<link rel="stylesheet" href="/resources/css/general.css">

<script src="/resources/js/validatePlayer.js"></script>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<h2>Adding Player Details</h2>
		<form name="playerForm" id="playerForm" method="post"
			action="showPlayer" modelAttribute="player">
			<div class="form-group">
				<label for="playerName">Player Name:</label> <input type="text"
					class="form-control" placeholder="Enter Player Name"
					id="playerName" name="playerName"></input>
			</div>
			
			
			<div>
				<label for="age">Player Age:</label> <input type="number"
					class="form-control" id="age" name="age" placeholder="Enter Age:">
			</div>

			<label for="subject">Select Player Type : </label>
			<div id="type">
				<input type="checkbox" value="Batsmen" id="type" name="type">
				<label for="type"> Batsmen</label> <input type="checkbox"
					value="WicketKeeper" id="type" name="type"> <label
					for="type"> Wicket Keeper</label> <input type="checkbox"
					value="Bowler" id="type" name="type"> <label for="type">
					Bowler</label>
			</div>

			<label for="team">Select Team for Player:</label>
			<div class="form-check">
				<select class="form-control" name="teamId" id="teamId"
					name="teamName">
					<option>----Select---</option>
					<c:forEach items="${teamList}" var="team">
            			<option value="${team.id}">${team.teamName}</option>
        			</c:forEach>
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>



</body>
</html>