
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
	$(document).ready(function() {
		$('.dropdown-toggle').dropdown();
	});
</script>

<title>Get Books</title>

<script type="text/javascript" src="/resources/js/header.js"></script>

<title>Book App</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="/">
			<button type="button" class="btn btn-primary ">Home</button>
		</a>


		<div class="nav-item dropdown">
			<button class="btn btn-secondary dropdown-toggle" role="button"
				id="bookDrop">Books</button>

			<div class="dropdown-menu">
				<a class="dropdown-item" href="/book/getAllBooks">Get Books</a>
				<a class="dropdown-item" href="/book/addBook">Add Books</a>
			</div>
		</div>

		<div class="dropdown">
			<button class="btn btn-secondary dropdown-toggle" type="button"
				id="writerDrop">Writers</button>
				
			<div class="dropdown-menu" >
				<a class="dropdown-item" href="/writer/getAllWriters" role="button">
						Get Writers</a>
						<a class="dropdown-item" href="/writer/addWriter"
					role="button">Add Writer</a>
			</div>
		</div>
	</nav>
</body>