<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Edit Profile</title>
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
	<link rel="apple-touch-icon" sizes="180x180" href="../images/apple-touch-icon.png">
	<link rel="icon" type="image/png" sizes="32x32" href="../images/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="../images/favicon-16x16.png">
	<link rel="manifest" href="../images/site.webmanifest">
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	<script src="https://kit.fontawesome.com/550ddecd5b.js" crossorigin="anonymous"></script>
	<script defer src="../js/main.js"></script>
</head>
<body>
	<header class="headers">
		<h1 class="main-header">Edit Profile</h1>
		<hr>
	</header>
	
	<section class="container">
		<div class="mw-415">
			<div class="form-wrapper">
				<form:form action="${pageContext.request.contextPath}/account/processProfileEdits" method="post" modelAttribute="crmUser">
					<div class="input-group">
						<form:errors path="firstName" cssClass="error" />
						<span>First name: </span>
						<form:input class="form-control" path="firstName" value="${user.firstName}" maxlength="20" required="required" />
					</div>
					<div class="input-group">
						<form:errors path="lastName" cssClass="error" />
						<span>Last name: </span>
						<form:input class="form-control" path="lastName" value="${user.lastName}" maxlength="20" required="required" />
					</div>
					<div class="input-group">
						<form:errors path="pinNumber" cssClass="error" />
						<span>New PIN number: </span>
						<form:password path="pinNumber" id="newPin" class="form-control pin-input numbers-only" minlength="4" maxlength="4" required="required" />
						<i id="eyeIcon" class="fas fa-eye-slash" onmouseover="displayPin()" onmouseout="hidePin()"></i>
					</div>
					<div class="input-group">
						<form:errors path="matchingPinNumber" cssClass="error" />
						<span>Confirm new PIN number: </span>
						<form:password class="form-control numbers-only" path="matchingPinNumber" minlength="4" maxlength="4" required="required" />
					</div>
					<div>
						<button class="button submit-form" type="submit">Submit</button>
					</div>
				</form:form>
			</div>
		</div>
	</section>
	
	<footer class="edit-profile-footer">
		<a class="back button" href="${pageContext.request.contextPath}/account/homepage" role="button" aria-pressed="false">
			<i class="fas fa-long-arrow-alt-left"></i>
		</a>
	</footer>
</body>
</html>