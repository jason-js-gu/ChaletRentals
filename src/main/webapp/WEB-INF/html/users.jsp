<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Chalet Rentals | Users</title>
<%@ include file="head.jsp"%>
</head>
<body>
	<div id="container-wrapper">
		<div class="cr01 section-main">
			<div class="container">
				<%@ include file="nav.jsp"%>
				<%@ include file="message.jsp"%>
				<div class="row pt-5">
					<c:if test="${users != null}">
						<c:forEach var="user" items="${users}">
							<div class="col-12 col-sm-12 col-md-4 col-lg-3 mb-3">
								<div class="card">
									<img src="${pageContext.request.contextPath}/img/profile.png"
										class="card-img-top" alt="profile">
									<form action="/users" method="post" class="card-body">
										<h5 class="card-title">
											<c:out value="${user.username}" />
										</h5>
										<input type="hidden" name="userid" value="${user.userID}">
										<p class="card-text">
											Email:
											<c:out value="${user.email}" />
										</p>
										<c:if test="${user.isChaletOwner()}">
											<p class="card-text">Status: Chalet Owner</p>
											<p class="card-text">
												Telephone:
												<c:out value="${user.telephone}" />
											</p>
										</c:if>
										<c:if test="${!user.isChaletOwner()}">
											<p class="card-text">Status: Tourist</p>
										</c:if>
										<button class="btn btn-danger">Delete This User</button>
									</form>
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

