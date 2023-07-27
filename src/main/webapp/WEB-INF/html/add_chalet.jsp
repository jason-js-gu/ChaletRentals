<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Chalet Rentals | Add Chalet</title>
<%@ include file="head.jsp"%>
</head>
<body>
	<div id="container-wrapper">
		<div class="cr01 section-main">
			<div class="container">
				<%@ include file="nav.jsp"%>
				<%@ include file="message.jsp"%>
				
				<div class="div-form">
					<c:if test="${!update_chalet}">
					<form action="/add_chalet" method="post" onsubmit="return validate()" 
					class="shadow m-auto p-3 bg-body-tertiary rounded" enctype="multipart/form-data">					
						<div class="mb-3">
							<label for="chaletnameInput" class="form-label">Chalet Name</label> 
							<input type="text" name="chaletname" class="form-control" id="chaletnameInput">
						</div>
						<div class="mb-3">
							<label for="addressInput" class="form-label">Address</label> 
							<input type="text" name="address" class="form-control" id="addressInput">
						</div>
						<div class="mb-3">
							<label for="descriptionInput" class="form-label">Description</label>
							<textarea class="form-control" name="description" id="descriptionInput" rows="5" ></textarea>							
						</div>
						<div class="mb-3">							
							<label class="form-label" for="priceInput">Price (per night)</label>
							<input type="text" name="price" class="form-control" id="priceInput" placeholder="199.90 or 200">
						</div>
						<div class="mb-3">
							<label for="photos" class="form-label">Upload Photos</label>
							<input type="file" name="photos" id="photos" class="form-control" multiple="multiple">
						</div>						
						<button class="btn btn-primary mt-3">Add My Chalet</button>
						</form>
						</c:if>
						<c:if test="${update_chalet}">		
					<form action="/add_chalet" method="post" onsubmit="return validate()" 
					class="shadow m-auto p-3 bg-body-tertiary rounded" enctype="multipart/form-data">
						<input type="hidden" name="chaletid" class="form-control" value="${chalet.chaletID}">					
						<div class="mb-3">
							<label for="chaletnameInput" class="form-label">Chalet Name</label> 
							<input type="text" name="chaletname" class="form-control" value="${chalet.name}" id="chaletnameInput">
						</div>
						<div class="mb-3">
							<label for="addressInput" class="form-label">Address</label> 
							<input type="text" name="address" class="form-control" value="${chalet.address}" id="addressInput">
						</div>
						<div class="mb-3">
							<label for="descriptionInput" class="form-label">Description</label>
							<textarea class="form-control" name="description" id="descriptionInput" rows="5" >${chalet.description}</textarea>
						</div>
						<div class="mb-3">							
							<label class="form-label" for="priceInput">Price (per night)</label>
							<input type="text" name="price" class="form-control" value="${chalet.price}" id="priceInput" placeholder="199.90 or 200">
						</div>
						<div class="mb-3">
							<label for="photos" class="form-label">Upload Photos</label>
							<input type="file" name="photos" id="photos" value="${chalet.photos}" class="form-control" multiple="multiple">
						</div>						
						<button class="btn btn-primary mt-3">Update My Chalet</button>
					</form>						
						</c:if>

				</div>
			</div>
		</div>
		<div class="cr01 cr02"></div>
		<%@ include file="footer.jsp"%>
	</div>
		<script>
            

            function validate(){
	            var username = document.getElementById("usernameInput").value;
	            var password = document.getElementById("pwdInput").value;
	            var email = document.getElementById("emailInput").value;           	
            	if(username==null || username.trim()==""){
            		alert("Username is required!");
            		return false;
            	}
            	if(password==null || password.trim()==""){
            		alert("Password is required!");
            		return false;
            	}
            	if(email==null || email.trim()==""){
            		alert("Email is required!");
            		return false;
            	}
            	return true;
            }
            
        </script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

