<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<c:url var="addAction" value="/addUser" ></c:url>

<form:form action="${addAction}" method="POST"  modelAttribute="user">
	<form:label path="username">
		<spring:message text="Username" />
	</form:label>

	<form:input path="username" />
	
	
	
</form:form>