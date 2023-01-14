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
<link rel="stylesheet" href="/resources/css/home.css">
<link rel="stylesheet" href="/resources/css/general.css">

</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="parallax">

		<div class="myCanvas centre">
			<canvas id="myCanvas"></canvas>
		</div>
		

	</div>
	
		<script>
		var c = document.getElementById("myCanvas");
		var ctx = c.getContext("2d");

		ctx.font = "25px Cambria";

		ctx.fillText("Indian Premier League", 10, 100);

		$("#myCanvas").mouseenter(function() {
			$("#myCanvas").animate({
				width: '900px',
			},"slow");
		});
		$("#myCanvas").mouseleave(function() {
			$("#myCanvas").animate({
				height: "200px",
			},"slow");
		});
	</script>

</body>
</html>