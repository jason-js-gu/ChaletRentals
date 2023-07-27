<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chalet Rentals</title>
<%@ include file="head.jsp"%>
</head>
<body>
	<div id="container-wrapper">
		<div class="cr01 section-main">
		<div class="container">
			<%@ include file="nav.jsp"%>
			<div id="hero" class="carousel slide carousel-fade"
				data-bs-ride="carousel">
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#hero" data-bs-slide-to="0"
						class="active" aria-current="true" aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#hero" data-bs-slide-to="1"
						aria-label="Slide 2"></button>
					<button type="button" data-bs-target="#hero" data-bs-slide-to="2"
						aria-label="Slide 3"></button>
				</div>
				<div class="carousel-inner">
				<c:if test="${heros != null}">
					<c:forEach var="hero" items="${heros}">
					<div class="carousel-item">
						<img
							src="${pageContext.request.contextPath}/img/${hero.photos.get(0)}"
							class="d-block w-100" alt="" height="800">
						<div class="carousel-caption d-none d-md-block">
							<h1><a href="/booking?chaletID=${hero.chaletID}">${hero.name}</a></h1>
							<h5>${hero.description}</h5>
						</div>
						<div class="hero-bg"></div>
					</div>
					</c:forEach>
				</c:if>

				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#hero" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#hero" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
			<div id="content" class="mt-5">
				<h1>Summer Destinations</h1>
				<p>Special chalets for you and let you enjoy summer</p>
				<div id="gallary">
					<div class="row">
					<c:set var="user" value="${sessionScope.user}" />
					
					<c:if test="${chalets!=null}">
						<c:forEach var="chalet" items="${chalets}"> 
						<div class="col-12 col-sm-12 col-md-6 col-lg-6 mb-3">
							<div class="card">
								<img src="${pageContext.request.contextPath}/img/${chalet.photos.get(0)}" height="400"
									class="card-img-top" alt="hero1">
								<div class="card-body">
									<div class="d-flex justify-content-between">
									<h5 class="card-title">${chalet.name}</h5>
									<span class="text-right">$${chalet.price}/day</span>
									</div>
									<img src="${pageContext.request.contextPath}/img/location.png" width="20" />
									<span class="card-text">${chalet.address}</span>
									<p class="mt-3 card-text">${chalet.description}</p>
									<c:if test="${user != null && user.userID == chalet.userID}">
									<div class="d-flex justify-content-between">									
									<a href="/add_chalet?chaletID=${chalet.chaletID}" class="btn btn-primary">Update My Chalet</a>
									<a href="#" class="btn btn-danger">Delete</a>
									</div>
									</c:if>
									<c:if test="${user == null || user.userID != chalet.userID}">
									<a href="/booking?chaletID=${chalet.chaletID}" class="btn btn-success">Book Now</a>
									</c:if>
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
		</div>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
		<script>
			var hero_active = document.querySelector(".carousel-item");
			hero_active.className += " active";
		</script>
</body>
</html>