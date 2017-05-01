 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
 
 <c:if test="${pageContext.request.userPrincipal.name != null}">
     <form id="logoutForm" method="POST" action="${contextPath}/logout">
         <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
     </form>
	 <div class="row">
	 	<div class="col-xs-12">
	 		<h4 class="text-center">Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h4>
	 	</div>
	 </div>
     <div class="row space-top">
     	<div class="col-xs-4 text-center">
     		<a href="<c:url value="/product/new"/>" class="btn btn-success">Publicar producto</a>
     	</div>
     	<div class="col-xs-4 text-center">
     		<a href="<c:url value="/product/list"/>" class="btn btn-success">Comprar producto</a>
     	</div>
     	<div class="col-xs-4 text-center">
     		<a href="<c:url value="/product/history"/>" class="btn btn-success">Historial Ventas</a>
     	</div>
     </div>
     

 </c:if>