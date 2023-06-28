<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Chalet Rentals | Login</title>
<%@ include file="head.jsp"%>
</head>
<body>
	<div id="container-wrapper">
		<div class="cr01 section-main">
			<div class="container">
				<%@ include file="nav.jsp"%>
				<div class="div-form">
					<form class="shadow m-auto p-3 bg-body-tertiary rounded">
						<div class="mb-3">
							<label for="usernameInput" class="form-label">Username</label> <input
								type="text" class="form-control" id="usernameInput">
						</div>
						<div class="mb-1">
							<label for="pwdInput" class="form-label">Password</label> <input
								type="password" class="form-control" id="pwdInput">
						</div>
						<div class="mb-3 text-end">
							<p><a href="/reset-password">Forgot your password?</a></p>
						</div>
						<button class="btn btn-primary">Login</button>
					</form>
				</div>
			</div>
		</div>
		<div class="cr01 cr02"></div>
		<%@ include file="footer.jsp"%>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

