<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Saving Account Withdraw</title>
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
		<h1 class="main-header">Savings Account</h1>
		<p class="balance-amount"><sup>$</sup>${balance}</p>
		<p class="current-balance-subtitle">Current Balance</p>
		<hr>
	</header>
	
	<section class="container">
		<div class="mw-415">
			<h2 class="amount-header">Withdraw Amount</h2>
			<div class="form-wrapper">
				<form:form action="${pageContext.request.contextPath}/account/withdrawSaving" method="post" modelAttribute="theAmount">
					<c:if test="${not empty negativeBalance}">
						<div class="error">
							<b>ERROR</b>: ${negativeBalance}
						</div>
					</c:if>
					<form:errors path="dollars" cssClass="error" />
					<form:errors path="cents" cssClass="error" />
					<div class="total-amount">
						<b>$</b>
						<div class="dollar-field">
							<form:input class="form-control numbers-only" path="dollars" minlength="1" maxlength="5" value="0" />
						</div>
						<b>.</b>
						<div class="cent-field">
							<form:input class="form-control numbers-only" path="cents" minlength="1" maxlength="2" value="00" />
						</div>
					</div>
					<div class="submit-amount-btn">
						<button class="button green-button submit-form" type="submit">Withdraw</button>
					</div>
				</form:form>
			</div>
		</div>
	</section>
	
	<footer class="saving-account-footer">
			<div class="inline-block">
				<a class="back button" href="${pageContext.request.contextPath}/account/homepage" role="button" aria-pressed="false">
					<i class="fas fa-long-arrow-alt-left"></i>
				</a>
			</div>
			<form:form class="align-right" action="${pageContext.request.contextPath}/logout" method="post">
				<button class="button footer-button" type="submit">Logout</button>
			</form:form>
	</footer>
</body>
</html>