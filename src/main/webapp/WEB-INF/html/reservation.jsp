<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chalet Reservation</title>
<%@ include file="head.jsp"%>
</head>
<body>
	<div id="container-wrapper">
		<div class="cr01 section-main">
		<div class="container">
			<%@ include file="nav.jsp"%>
			<%@ include file="message.jsp"%>
			<div id="hero" class="">
				<div class="">
				<c:if test="${chalet != null}">					
					<div>
						<img
							src="${pageContext.request.contextPath}/img/${chalet.photos.get(0)}"
							class="d-block w-100" alt="" height="800">
						<div class="mt-3">	
							<h5>${chalet.name}</h5>						
							<p>${chalet.description}</p>
						</div>						
					</div>					
				</c:if>
				</div>

			</div>
			<div id="content" class="mt-3 mb-5">
				<form action="/booking" method="post" class="shadow m-auto p-3 bg-body-tertiary rounded row g-3">
					<input type="hidden" name="chaletid" value="${chalet.chaletID}" />
					<input type="hidden" name="totalprice" id="totalprice" value="" />
					
					<div class="col-md-6">
						<label class="form-label">Check In</label>
						<input type="datetime-local" name="checkin" id="checkin" value="${reservation.checkin.toString().substring(0,16)}" class="form-control" />
					</div>
					<div class="col-md-6">
						<label class="form-label">Check Out</label>
						<input type="datetime-local" name="checkout" id="checkout" value="${reservation.checkout.toString().substring(0,16)}" class="form-control" />
					</div>
					<div class="col-12">
						<p>Total Price: $<span id="total_price">${reservation.totalPrice}</span></p>
					</div>
					<c:if test="${reservation == null}">
						<button class="btn btn-success mb-3">Confirm Reservation</button>
					</c:if>
					<c:if test="${reservation != null}">
						<input type="hidden" name="reservationid" value="${reservation.reservationID}" />
						<button class="btn btn-success mb-3">Update My Reservation</button>
					</c:if>
				</form>
			</div>
			</div>
			<div class="cr01 cr02"></div>
			<%@ include file="footer.jsp"%>
		</div>
		</div>
		<script>
			var checkin = document.getElementById("checkin");
			var checkout = document.getElementById("checkout")
			checkin.addEventListener('input', calculate);
			checkout.addEventListener('input', calculate);
			
			function calculate(){
				if(checkin.value != "" && checkout.value != ""){
					var dstr1 = checkin.value.split('T')[0].split('-');					
					var dstr2 = checkout.value.split('T')[0].split('-');
					var checkin_date = new Date(dstr1[0],dstr1[1],dstr1[2]);
					var checkout_date = new Date(dstr2[0],dstr2[1],dstr2[2]);		
					var difference_in_time = checkout_date.getTime() - checkin_date.getTime();					
					var difference_in_days = difference_in_time /(1000 * 3600 * 24);
					var total_price = ${chalet.price} * Math.ceil(difference_in_days);
					var tp = document.getElementById("total_price");
					var tp_hidden = document.getElementById("totalprice");
					tp.innerHTML = total_price;	
					tp_hidden.value = total_price;
				}
			}			

		</script>		
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>