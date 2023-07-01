
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<nav class="navbar p-3 navbar-expand-lg bg-body-tertiary">

	<a class="navbar-brand text-font" href="/home"> <img
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
				aria-current="page" href="/home">Home</a></li>

			<li class="nav-item"><a class="nav-link" href="/reservation">Reservation</a>
			</li>
			<c:if test="${request.getSession().getAttribute('role').title == 'admin' }">
				<li class="nav-item"><a class="nav-link" href="/users">Users</a>
			</c:if>
		</ul>
		<div class="text-right">
			<c:if test="${request.getSession().getAttribute('user') != null}">		
			<span class="text-deco">welcome, <c:out value="${request.getSession().getAttribute('user').username}" /></span>
			&nbsp;|&nbsp;
			<span class="text-deco"><a href="/logout">logout</a></span>
			</c:if>
			<c:if test="${request.getSession().getAttribute('user') == null}">		
			<span class="text-deco"><a href="/login">login</a></span>			
			&nbsp;|&nbsp;
			<span class="text-deco"><a href="/register">register</a></span>
			</c:if>
		</div>
	</div>

</nav>