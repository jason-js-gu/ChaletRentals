<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Chalet Rentals | Reset Password</title>
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
					<h2>Validate your code</h2>
					<p>Please enter the code we just sent to you.</p>
					<form class="form" action="validate-code" method="post">
						<div class="mb-3">
							<label for="codeInput" class="form-label">Enter the code you received</label> 
							<input type="text" name="code" class="form-control" id="codeInput">
						</div>
						<button class="btn btn-primary">Submit</button>						
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