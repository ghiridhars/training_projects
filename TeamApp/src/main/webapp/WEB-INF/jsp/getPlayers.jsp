<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Players</title>


<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<!-- Latest compiled JavaScript -->
<!-- jQuery library -->
<link rel="stylesheet" href="/resources/css/general.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<script type="text/javascript">
	$(function() {
		$("#submit").on("click", function(){
			var team = $("#teamName").val();
			console.log(team);
			$.ajax({
				type : 'GET',
				url : '/player/getPlayersByTeam/'+team,
				data:{},
				dataType:'json',
				success : function(data) {
					console.log(data);
					var s = '<tr><th>Name</th><th>Player Type</th><th>Age</th></tr>';
					for (var i = 0; i < data.length; i++) {
						 s+='<tr><td>'+ data[i].playerName+'</td><td>'+ data[i].type+'</td><td>' + data[i].age+'</td></tr>';
					}
					console.log(s);
					$('#players').html(s);
				},
				error : function(data){
					window.location.href="/player/error/"+(data.responseText);
					}
			});
			$.ajax({
				type : 'GET',
				url : '/player/getAverageAge/'+team,
				data:{},
				dataType:'json',
				success : function(data) {
					console.log(data);
					var s = '<tr><th>Average Age</th><td>'+data+'</td></tr>';
					console.log(s);
					$('#averageAge').html(s);
				},
				error : function(data){
					window.location.href="/player/error/"+(data.responseText);
					}
			});
		});
	});
</script>

</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<h3>Player List</h3>

		<div class="form-group">
			<label for="teamName">Enter Team Name :</label> <input type="text"
				class="form-control" placeholder="Enter Team Name" id="teamName"
				name="teamName"></input>
		</div>
				
		<button id="submit" type="submit" class="btn btn-primary">Submit</button>

		<table id="players" class="table table-striped table-bordered">
		</table>
		
		<table id="averageAge" class="table table-striped table-bordered">
		</table>

	</div>



</body>
</html>