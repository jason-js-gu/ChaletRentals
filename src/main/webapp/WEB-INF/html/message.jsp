<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<c:if test="${status != null && status.equals('success')}">
<div  class="alert alert-success mt-2" role="alert"><c:out value="${message}" /> </div>
</c:if>
<c:if test="${status !=null && status.equals('failed')}">
<div  class="alert alert-danger mt-2" role="alert"><c:out value="${message}" /> </div>
</c:if>