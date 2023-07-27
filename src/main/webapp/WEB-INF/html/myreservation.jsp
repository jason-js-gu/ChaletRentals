<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Chalet Rentals | My Reservation</title>
<%@ include file="head.jsp"%>
</head>
<body>
	<div id="container-wrapper">
		<div class="cr01 section-main">
			<div class="container">
				<%@ include file="nav.jsp"%>
				<%@ include file="message.jsp"%>
				<div class="row pt-5">
					<c:if test="${reservations_chalets != null}">
						<c:forEach var="rp" items="${reservations_chalets}">
							<div class="col-12 col-sm-12 col-md-4 col-lg-6 mb-3">
								<div class="card">
									<img src="${pageContext.request.contextPath}/img/${rp[1].photos.get(0)}"
										class="card-img-top" alt="profile">
									<div class="card-body">
										<h5 class="card-title">
											<c:out value="${rp[1].name}" />
										</h5>
										<input type="hidden" name="reservationid" value="${rp[0].reservationID}">
										<p class="card-text">
											Check In : ${rp[0].checkin}
										</p>
										<p class="card-text">
											Check Out : ${rp[0].checkout}
										</p>
										<p class="card-text">
											Booked At : ${rp[0].bookedAt}
										</p>
										<p class="card-text">
											Price/day : $${rp[1].price}
										</p>
										<p class="card-text">
											Sub_total : $${rp[0].totalPrice}
										</p>
										<div class="d-flex justify-content-between">
										<a href="/booking?id=${rp[0].reservationID}">
											<button class="btn btn-primary">Update</button>
										</a>
										<a href="/delete_reservation?id=${rp[0].reservationID}">
											<button class="btn btn-danger">Cancle This Reservation</button>
										</a>
										</div>										
										
									</div>
								</div>
							</div>
						</c:forEach>
					</c:if>

				</div>
			</div>
		</div>
	</div>
	<div class="cr01 cr02"></div>
	<%@ include file="footer.jsp"%>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

