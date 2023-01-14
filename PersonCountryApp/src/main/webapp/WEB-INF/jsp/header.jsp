<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Document</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
	
</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>

<!-- Bootstrap files (jQuery first, then Popper.js, then Bootstrap JS) -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"
	type="text/javascript"></script>

<style type="text/css">
body {
	font-size: 18px;
	position: sticky;
}

.sticky {
	position: fixed;
	width: 100%;
	left: 0;
	top: 0;
	z-index: 100;
	border-top: 0;
}

.navbar {
	background: rgb(40, 165, 214, 0.99999);
}

.navbar-nav {
	font-size: 18px;
}

@media screen and (max-width: 768px) {
	.nav {
		width: 100%;
		margin-bottom: 35px;
	}
}

@media all and (min-width: 992px) {
	.navbar {
		padding-top: 0;
		padding-bottom: 0;
	}
	.navbar .has-megamenu {
		position: static !important;
	}
	.navbar .megamenu {
		left: 0;
		right: 0;
		width: 100%;
		padding: 20px;
	}
	.navbar .nav-link {
		padding-top: 1rem;
		padding-bottom: 1rem;
	}
}

@media screen and (max-width: 480px) {
	.logo {
		font-size: 150px;
	}
}
</style>

<script>
	$(document).ready(function() {
		var stickyNavTop = $('.navbar').offset().top;

		var stickyNav = function() {
			var scrollTop = $(window).scrollTop(); // our current vertical position from the top
			if (scrollTop > stickyNavTop) {
				$('.navbar').addClass('sticky');
			} else {
				$('.navbar').removeClass('sticky');
			}
		};

		stickyNav();
		$(window).scroll(function() {
			stickyNav();
		});
	});
</script>

</head>

<body>

	<nav id="nav" class="navbar navbar-expand-lg">
		<div class="navbar-brand">
			<a href="/"><h2>Home</h2></a>
		</div>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#main_nav">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse navbar-light" id="main_nav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/"> About </a></li>
				<li class="nav-item"><a class="nav-link"
					href="/country/addCountry"> Country Data </a></li>

				<li class="nav-item"><a class="nav-link dropdown-toggle"
					href="#" data-toggle="dropdown">State Data</a>
					<div class="dropdown-menu megamenu" role="menu">
						<div class="row">
							<ul class="navbar-nav">
								<li><a class="dropdown-item" href="/state/addState">
										Add State</a></li>
								<li><a class="dropdown-item" href="/state/getStates">
										Show State</a></li>
							</ul>
						</div>
					</div></li>
				<li class="nav-item dropdown has-megamenu"><a
					class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">Person
						Data</a>
					<div class="dropdown-menu megamenu" role="menu">
						<div class="row">
							<ul class="navbar-nav">
								<li><a class="dropdown-item" href="/person/addPerson">
										Person Registration</a></li>
								<li><a class="dropdown-item" href="/person/getAllData">
										Show Data</a></li>
							</ul>
						</div>
					</div></li>
				<li class="nav-item"><a class="nav-link"
					href="/logout"> Log out</a></li>
			</ul>

		</div>
		<!-- end row -->
		</div>
		<!-- dropdown-mega-menu.// -->
		</li>
		</ul>

		</div>

	</nav>
</body>

</html>