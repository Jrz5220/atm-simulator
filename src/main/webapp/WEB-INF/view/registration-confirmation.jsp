<!DOCTYPE html>

<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Registration Confirmation</title>
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
	<link rel="apple-touch-icon" sizes="180x180" href="images/apple-touch-icon.png">
	<link rel="icon" type="image/png" sizes="32x32" href="images/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="images/favicon-16x16.png">
	<link rel="manifest" href="images/site.webmanifest">
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<header class="headers">
		<h1 class="main-header">Registration Confirmation</h1>
	</header>
	<section class="container">
		<div class="mw-415">
			<div class="successful-registration-message">
				<p>Congratulations ${crmUser.firstName}! You successfully registered your new account.</p>
				<br>
				<p>You can now login.</p>
				<br>
				<div class="return-to-login">
					<a class="button submit-form" href="${pageContext.request.contextPath}/loginPage" role="button" aria-pressed="false">
						Login
					</a>
				</div>
			</div>
		</div>
	</section>
</body>

</html>