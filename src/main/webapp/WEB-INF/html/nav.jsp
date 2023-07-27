
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<nav class="navbar p-3 navbar-expand-lg bg-body-tertiary">

	<a class="navbar-brand text-font" href="/"> <img
		src="${pageContext.request.contextPath}/img/logo.png" alt="Logo"
		width="24" height="24" class="d-inline-block img-position">
		Chalet Rentals
	</a>
	<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
		data-bs-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav me-auto mb-2 mb-lg-0">
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="/">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="/reservation">My Reservation</a>
			</li>
			<c:set var="user" value="${sessionScope.user}" />
			<c:if test="${user!=null && user.email=='cst8288g10@gmail.com'}">
				<li class="nav-item"><a class="nav-link" href="/users">Users</a>
			</c:if>
			<c:if test="${user!=null}">
				<li class="nav-item"><a class="nav-link" href="/profile">My Profile</a>
			</c:if>
			<c:if test="${user!=null && user.isChaletOwner()}">
				<li class="nav-item"><a class="nav-link" href="/add_chalet">Add Chalet</a>
			</c:if>
		</ul>
		<div class="text-right">
			<c:if test="${user != null}">		
			<span class="text-deco">welcome, <span style="color:#00adb5"><c:out value="${user.username}" /></span></span>
			&nbsp;|&nbsp;
			<span class="text-deco"><a href="/logout">logout</a></span>
			</c:if>
			<c:if test="${user == null}">		
			<span class="text-deco"><a href="/login">login</a></span>			
			&nbsp;|&nbsp;
			<span class="text-deco"><a href="/register">register</a></span>
			</c:if>
		</div>
	</div>

</nav>