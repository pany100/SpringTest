 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
 
 <c:if test="${pageContext.request.userPrincipal.name != null}">
     <form id="logoutForm" method="POST" action="${contextPath}/logout">
         <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
     </form>

     <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>

 </c:if>