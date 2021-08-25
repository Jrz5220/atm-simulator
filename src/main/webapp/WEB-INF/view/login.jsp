<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>ATM Simulator</title>
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
	<link rel="apple-touch-icon" sizes="180x180" href="images/apple-touch-icon.png">
	<link rel="icon" type="image/png" sizes="32x32" href="images/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="images/favicon-16x16.png">
	<link rel="manifest" href="images/site.webmanifest">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script defer src="js/main.js"></script>
</head>

<body>
	<section class="login-section">
		<div class="loginbox mw-415">
			<c:if test="${not empty registerError}">
				<div class="error">${registerError}</div>
			</c:if>
			<h1>Welcome to the ATM</h1>
			<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">
				<div class="alert-messages">
					<c:if test="${param.error != null}">
						<div class="alert">
							Invalid account number or pin number.
						</div>
					</c:if>
					<c:if test="${param.logout != null}">
						<div class="alert">
							You have been logged out.
						</div>
					</c:if>
				</div>
				
				<!-- account number (username for security filters) -->
				<div class="input-group">
					<span><b>ACCOUNT</b> number</span>
					<input type="text" class="form-control numbers-only" name="username" minlength="4" maxlength="4" required />
				</div>
				
				<!-- pin number (password for security filters) -->
				<div class="input-group">
					<span><b>PIN</b> number</span>
					<input type="password" class="form-control numbers-only" name="password" minlength="4" maxlength="4" required />
				</div>
				<div>
					<button class="submit-form button" type="submit">Enter</button>
				</div>
			</form:form>
		</div>
	</section>
	<footer class="login-footer">
		<a class="button footer-button" href="${pageContext.request.contextPath}/showRegistrationForm" role="button" aria-pressed="false">
			Register New Account
		</a>
	</footer>
</body>

</html>