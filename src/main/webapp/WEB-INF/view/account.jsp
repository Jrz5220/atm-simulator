<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>ATM Simulator</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
	<link rel="apple-touch-icon" sizes="180x180" href="../images/apple-touch-icon.png">
	<link rel="icon" type="image/png" sizes="32x32" href="../images/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="../images/favicon-16x16.png">
	<link rel="manifest" href="../images/site.webmanifest">
	<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>

<body>
	<header class="headers">
		<h1 class="main-header">Welcome ${user.firstName}</h1>
		<div class="alert-messages">
			<c:if test="${not empty updatedProfileMessage}">
				<div class="alert">
					${updatedProfileMessage}
				</div>
			</c:if>
		</div>
	</header>
	<security:authorize access="hasRole('CUSTOMER')">
		<section class="authorized-user-accounts">
			<!-- accordian flush -->
			<div class="accordion accordion-flush" id="accordionFlushExample">
			  <div class="accordion-item mb-4">
			    <h2 class="accordion-header" id="flush-headingOne">
			      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
			        Checking Account
			      </button>
			    </h2>
			    <div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
			      <div class="accordion-body">
			      	<div class="link">
			      		<a href="${pageContext.request.contextPath}/account/showWithdrawCheckingPage">Withdraw</a>
			      	</div>
			      	<div class="link">
			      		<a href="${pageContext.request.contextPath}/account/showDepositCheckingPage">Deposit</a>
			      	</div>
			      </div>
			    </div>
			  </div>
			  <div class="accordion-item">
			    <h2 class="accordion-header" id="flush-headingTwo">
			      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
			        Savings Account
			      </button>
			    </h2>
			    <div id="flush-collapseTwo" class="accordion-collapse collapse" aria-labelledby="flush-headingTwo" data-bs-parent="#accordionFlushExample">
			    	<div class="accordion-body">
				      	<div class="link">
				      		<a href="${pageContext.request.contextPath}/account/showWithdrawSavingPage">Withdraw</a>
				      	</div>
				      	<div class="link">
				      		<a href="${pageContext.request.contextPath}/account/showDepositSavingPage">Deposit</a>
				      	</div>
					</div>
			    </div>
			  </div>
			</div>
		</section>
	</security:authorize>
	<footer class="account-footer">
		<form:form class="inline-block" action="${pageContext.request.contextPath}/logout" method="post">
			<button class="button footer-button" type="submit">Logout</button>
		</form:form>
		<a class="button footer-button align-right" href="${pageContext.request.contextPath}/account/editProfile" role="button" aria-pressed="false">
			Edit Profile
		</a>
	</footer>
</body>

</html>