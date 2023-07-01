<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
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
				<div class="row pt-5">
					
				<div class="col-12 col-sm-12 col-md-4 col-lg-4">
				<div class="shadow m-auto p-3 bg-body-tertiary">
					<img src="${pageContext.request.contextPath}/img/profile.png" width="200" alt="profile">
				</div>
				</div>
				
				<div class="col-12 col-sm-12 col-md-8 col-lg-8">
					<c:set var="update_profile" value="${param['update_profile']}" />
					
					<c:if test="${!update_profile}">
					<c:set var="user" value="${session.getAttribute('user')}" />	
					<div class="shadow m-auto p-3 bg-body-tertiary">
						<div class="mb-3">
							<label for="usernameInput" class="form-label">Username: 
								<c:out value="${user.username}" />
							</label> 							
						</div>
						<div class="mb-3">
							<label for="pwdInput" class="form-label">Password: 
								<c:out value="${user.password}" />
							</label> 
							
						</div>
						<div class="mb-3">
							<label for="emailInput" class="form-label">Email address: 
								<c:out value="${user.email}" />							
							</label>
						</div>
						<c:if test="${user.isChaletOwner}">
						<div class="mb-3">
							<label class="form-label" for="chx"> Status: Chalet Owner </label>
						</div>
						<div class="mb-3 mt-2 d-none" id="div_tel">
							<label for="telephone" class="form-label">Telephone: 
								<c:out value="${user.telephone}" />								
							</label>
						</div>
						</c:if>
						<c:if test="${!user.isChaletOwner}">
						<div class="mb-3">
							<label class="form-label" for="chx"> Status: Tourist </label>
						</div>
						</c:if>						
						<a href="/profile?update_profile=true"><button class="btn btn-primary mt-3">Update My Profile</button></a>
					</div>
					</c:if>
				
				
					<c:if test="${update_profile}">	
					<form action="profile" method="post" class="shadow m-auto p-3 bg-body-tertiary">
						<input type="hidden" name="userid" class="form-control" value="${user.userID}">
						<div class="mb-3">
							<label for="usernameInput" class="form-label">Username</label> 
							<input type="text" name="username" value="${user.username}" class="form-control" id="usernameInput">
						</div>
						<div class="mb-3">
							<label for="pwdInput" class="form-label">Password</label> 
							<input type="password" name="password" value="${user.password}" class="form-control" id="pwdInput">
						</div>
						<div class="mb-3">
							<label for="emailInput" class="form-label">Email address</label>
							<input type="email" name="email" value="${user.email}" class="form-control" id="emailInput"
								placeholder="name@example.com">
						</div>
						<c:if test="${user.isChaletOwner}">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="isowner" checked id="chx">
							<label class="form-check-label" for="chx"> Chalet Owner </label>
						</div>
						<div class="mb-3 mt-2" id="div_tel">
							<label for="telephone" class="form-label">Telephone</label>
							<input type="text" name="telephone" value="${user.telephone}" id="telephone" class="form-control">
						</div>
						</c:if>
						<c:if test="${!user.isChaletOwner}">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="isowner" id="chx">
							<label class="form-check-label" for="chx"> Chalet Owner </label>
						</div>
						<div class="mb-3 mt-2 d-none" id="div_tel">
							<label for="telephone" class="form-label">Telephone</label>
							<input type="text" name="telephone" id="telephone" class="form-control">
						</div>
						</c:if>
						
						<button class="btn btn-primary mt-3">Submit</button>
					</form>
					</c:if>
				</div>
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

