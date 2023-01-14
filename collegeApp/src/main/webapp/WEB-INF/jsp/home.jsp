<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
	
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>College Management Home</title>

<link rel="stylesheet" href="/resources/css/general.css">
<link rel="stylesheet" href="/resources/css/homeStyle.css">
<script type="text/javascript" src="/resources/js/home.js"></script>

</head>
<body>

	<div class="container">

		<jsp:include page="header.jsp" />
		<div class="parallax">

			<div class="mask" style="background-color: rgba(173, 216, 230, 0.5)">
				<div class="d-flex justify-content-center align-items-center h-100">
					<div class="text-white">
						<div class="blockquote text-center">
							<h2 id="head">Welcome to College Management App</h2>
							<div id="rest">A College Management App to add and fetch
								details of student and colleges.Please select one of the options</div>
						</div>

						<div class="container">
							<div class="row">
								<div id="title1" class="col-sm-6">
									<div class="card text-center">
										<div>
											<img class="card-img" src="/resources/images/college.jpg"
												alt="Card image">
										</div>
										<div class="card-img-overlay">
											<div class="card-body">
												<div>
													<h4>Add College Data</h4>
												</div>
												<div id="content1">
													<p class="card-text">Click the below option to add the
														college data and store it into the database.</p>
													<a class="btn btn-primary" href="college/addCollege"
														role="button">Add College</a>
												</div>
											</div>
											<div class="card-body">
												<div>
													<h4 class="card-title">Get All College Data</h4>
												</div>
												<div id="content2">
													<p class="card-text">Click the below option to fetch
														all the college data from the database.</p>
													<a class="btn btn-primary" href="college/getAllColleges"
														role="button">View Colleges</a>
												</div>

											</div>

										</div>
									</div>
								</div>
								<div class="col-sm-6">
									<div id="title3" class="card text-center">
										<div>
											<img class="card-img" src="/resources/images/student.jpg"
												alt="Card image">
										</div>

										<div class="card-img-overlay">
											<div class="card-body">
												<h4 class="card-title">Add Student Data</h4>
												<div id="content3">
													<p class="card-text">Click the below option to add the
														student data and store it into the database.</p>
													<a class="btn btn-primary" href="student/addStudent"
														role="button">Add Student</a>

												</div>
											</div>
											<div class="card-body">
												<h4 class="card-title">Get Student Data By College</h4>
												<div id="content4">
													<p class="card-text">Click the below option to fetch
														all the student data from the database.</p>
													<a class="btn btn-primary" href="student/getStudents"
														role="button">View Students</a>
												</div>

											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>