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
<h1><c:out value="${pageContext.request.contextPath}" /></h1>
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
					<div class="carousel-item active">
						<img
							src="${pageContext.request.contextPath}/img/sebastian-staines-6_8nhHo4fDc-unsplash.jpg"
							class="d-block w-100" alt="hero1">
						<div class="carousel-caption d-none d-md-block">
							<h5>First slide label</h5>
							<p>Some representative placeholder content for the first
								slide.</p>
						</div>
					</div>
					<div class="carousel-item">
						<img src="${pageContext.request.contextPath}/img/hero1.jpg"
							class="d-block w-100" alt="hero2">
						<div class="carousel-caption d-none d-md-block">
							<h5>Second slide label</h5>
							<p>Some representative placeholder content for the second
								slide.</p>
						</div>
					</div>
					<div class="carousel-item">
						<img src="${pageContext.request.contextPath}/img/hero2.jpg"
							class="d-block w-100" alt="hero3">
						<div class="carousel-caption d-none d-md-block">
							<h5>Third slide label</h5>
							<p>Some representative placeholder content for the third
								slide.</p>
						</div>
					</div>
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
						<div class="col col-sm-12 col-md-6 col-lg-6 mb-3">
							<div class="card">
								<img src="${pageContext.request.contextPath}/img/hero1.jpg"
									class="card-img-top" alt="hero1">
								<div class="card-body">
									<h5 class="card-title">Card title</h5>
									<p class="card-text">Some quick example text to build on
										the card title and make up the bulk of the card's content.</p>
									<a href="#" class="btn btn-primary">Go somewhere</a>
								</div>
							</div>
						</div>
						<div class="col-12 col-sm-12 col-md-6 col-lg-6 mb-3">
							<div class="card">
								<img src="${pageContext.request.contextPath}/img/hero2.jpg"
									class="card-img-top" alt="hero2">
								<div class="card-body">
									<h5 class="card-title">Card title</h5>
									<p class="card-text">Some quick example text to build on
										the card title and make up the bulk of the card's content.</p>
									<a href="#" class="btn btn-primary">Go somewhere</a>
								</div>
							</div>
						</div>
						<div class="col col-sm-12 col-md-6 col-lg-6 mb-3">
							<div class="card">
								<img src="${pageContext.request.contextPath}/img/hero1.jpg"
									class="card-img-top" alt="hero1">
								<div class="card-body">
									<h5 class="card-title">Card title</h5>
									<p class="card-text">Some quick example text to build on
										the card title and make up the bulk of the card's content.</p>
									<a href="#" class="btn btn-primary">Go somewhere</a>
								</div>
							</div>
						</div>
						<div class="col-12 col-sm-12 col-md-6 col-lg-6 mb-3">
							<div class="card">
								<img src="${pageContext.request.contextPath}/img/hero2.jpg"
									class="card-img-top" alt="hero2">
								<div class="card-body">
									<h5 class="card-title">Card title</h5>
									<p class="card-text">Some quick example text to build on
										the card title and make up the bulk of the card's content.</p>
									<a href="#" class="btn btn-primary">Go somewhere</a>
								</div>
							</div>
						</div>
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
</body>
</html>