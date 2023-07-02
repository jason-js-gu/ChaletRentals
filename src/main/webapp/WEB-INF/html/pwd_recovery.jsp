<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Chalet Rentals | Password Recovery</title>
<%@ include file="head.jsp"%>
</head>
<body>
	<div id="container-wrapper">
		<div class="cr01 section-main">
			<div class="container">
				<%@ include file="nav.jsp"%>
				<%@ include file="message.jsp"%>
				<div class="div-form">
					<div class="div-dim shadow m-auto p-3 bg-body-tertiary rounded">
					<h2>Forgot your password?</h2>
					<p>Please follow three steps below to reset your password.</p>
					<ol>
						<li>Enter your email address which you have used to register</li>
						<li>Our system will send you an code to your email</li>
						<li>Enter the code on the next page</li>
					</ol>
					<form class="form" action="/reset-password" method="post">
						<div class="mb-3">
							<label for="emailInput" class="form-label">Enter your mail address</label> 
							<input type="email" name="email" class="form-control" id="emailInput">
						</div>
						<button class="btn btn-primary">Get Reset Code</button>						
					</form>
					</div>
				</div>
			</div>
		</div>
		<div class="cr01 cr02"></div>
		<%@ include file="footer.jsp"%>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>