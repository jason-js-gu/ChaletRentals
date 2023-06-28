<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Chalet Rentals | Register</title>
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
						<div class="mb-3">
							<label for="pwdInput" class="form-label">Password</label> <input
								type="password" class="form-control" id="pwdInput">
						</div>
						<div class="mb-3">
							<label for="emailInput" class="form-label">Email address</label>
							<input type="email" class="form-control" id="emailInput"
								placeholder="name@example.com">
						</div>
						<div class="form-check">
							<input class="form-check-input" type="checkbox" value="" id="chx">
							<label class="form-check-label" for="chx"> Chalet Owner </label>
						</div>
						<div class="mb-3 mt-2 d-none" id="div_tel">
							<label for="telephone" class="form-label">Telephone</label> <input
								type="text" id="telephone" class="form-control">
						</div>
						<button class="btn btn-primary mt-3">Register</button>
					</form>
				</div>
			</div>
		</div>
		<div class="cr01 cr02"></div>
		<%@ include file="footer.jsp"%>
	</div>
		<script>
            var div_chx = document.getElementById("div_tel");
            var chx = document.getElementById("chx");
            chx.addEventListener('change', e=>{
                div_chx.classList.toggle("d-none");
            });
        </script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

