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
		<script src="https://kit.fontawesome.com/550ddecd5b.js" crossorigin="anonymous"></script>
		<script defer src="js/main.js"></script>
	</head>
	<body>
		<header class="headers">
			<h1 class="main-header">Register Your New Account</h1>
			<hr>
		</header>
		
		<section class="container">
			<div class="mw-415">
				<div class="new-account-num">
					<p>Your new account number: <span class="new-account-number">${crmUser.accountNumber}</span></p>
				</div>
				<div class="form-wrapper">
					<form:form action="${pageContext.request.contextPath}/processRegistrationForm" modelAttribute="crmUser">
						<c:if test="${registrationError != null}">
							<div class="error-messages">
								<div class="alert">
									${registrationError}
								</div>
							</div>
						</c:if>
						
						<form:hidden path="accountNumber" value="${crmUser.accountNumber}" />
						
						<div class="input-group">
							<span>PIN number</span>
							<form:errors path="pinNumber" cssClass="error" />
							<form:password path="pinNumber" id="newPin" class="form-control pin-input numbers-only" minlength="4" maxlength="4" required="required" />
							<i id="eyeIcon" class="fas fa-eye-slash" onmouseover="displayPin()" onmouseout="hidePin()"></i>
						</div>
						
						<div class="input-group">
							<span>Confirm PIN number</span>
							<form:errors path="matchingPinNumber" cssClass="error" />
							<form:password path="matchingPinNumber" class="form-control numbers-only" minlength="4" maxlength="4" required="required" />
						</div>
						
						<div class="input-group">
							<span>First name</span>
							<form:errors path="firstName" cssClass="error" />
							<form:input path="firstName" class="form-control" maxlength="20" required="required" />
						</div>
						
						<div class="input-group">
							<span>Last name</span>
							<form:errors path="lastName" cssClass="error" />
							<form:input path="lastName" class="form-control" maxlength="20" required="required" />
						</div>
						
						<div>
							<button class="submit-form button" type="submit">Enter</button>
						</div>
					</form:form>
				</div>
			</div>
		</section>
		
		<footer class="register-footer">
			<a class="back button" href="${pageContext.request.contextPath}/loginPage" role="button" aria-pressed="false">
				<i class="fas fa-long-arrow-alt-left"></i>
			</a>
		</footer>
	</body>
</html>