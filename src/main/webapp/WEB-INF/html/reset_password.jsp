<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<%@ include file="message.jsp"%>
				<div class="div-form">
					<form action="/new-password" method="post" onsubmit="return validate()"
					class="shadow m-auto p-3 bg-body-tertiary rounded">
						<div class="mb-3">
							<label for="pwdInput" class="form-label">Enter new password</label>
							<input type="password" name="pwd" class="form-control" id="pwdInput">
						</div>
						<div class="mb-3">
							<label for="pwdInput1" class="form-label">Confirm new password</label>
							<input type="password" name="pwd1" class="form-control" id="pwdInput1">
						</div>
						<button class="btn btn-primary">Reset</button>
					</form>
				</div>
			</div>
		</div>
		<div class="cr01 cr02"></div>
		<%@ include file="footer.jsp"%>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<script>
	function validate(){
		var pwd = document.getElementById("pwdInput").value;
		var pwd1 = document.getElementById("pwdInput1").value;
		if(pwd==="" || pwd1===""){
			alert("Password is required!");
			return false;
		}
		if(pwd != pwd1){
			alert("Two passwords do not match!");
			return false;
		}
		return true;
	}
</script>

</body>
</html>
