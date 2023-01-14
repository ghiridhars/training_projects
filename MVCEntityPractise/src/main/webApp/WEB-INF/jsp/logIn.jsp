<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container">

		<nav class="navbar navbar-light">
			<a class="navbar-brand" href="#">Home</a>
			<div class="collapse navbar-collapse" id="main_nav">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="#">Home
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#"> About </a></li>
					<li class="nav-item"><a class="nav-link" href="#">
							Services </a></li>
					<li class="nav-item dropdown"><a
						class="nav-link  dropdown-toggle" href="#" data-toggle="dropdown">
							More items </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#"> Submenu item 1</a></li>
							<li><a class="dropdown-item" href="#"> Submenu item 2 </a></li>
						</ul></li>
				</ul>
			</div>
			<!-- navbar-collapse.// -->
		</nav>

		<div class="mb-3">
			<label for="emailId" class="form-label">Email
				address</label>
				<input type="email" class="form-control"
				id="email" placeholder="name@example.com">
		</div>
		
		<div class="mb-3">
			<label for="password" class="form-label">Passsword</label>
				<input type="text" class="form-control"
				id="password" placeholder="Password">
		</div>
		
		<button type="submit" id="save"></button>

	</div>




</body>
</html>