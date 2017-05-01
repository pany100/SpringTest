<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<spring:eval expression="@propertyConfigurer.getProperty('project.cdnUrl')" var="cdnUrl" />

<div class="row">
	<div class="text-center">
		<h2>Your products</h2>
	</div>
</div>
<div class="row">
	<div class="col-xs-offset-2 col-xs-10">
		<c:if test="${not empty myProducts}">
			<c:forEach var="listValue" items="${myProducts}">
				<div class="col-xs-4 panel panel-primary">
					<div class="panel-heading">
					  	<h3 class="panel-title">${listValue.name}</h3>
					</div>
					<div class="panel-body">
					  	<div class="col-xs-6">Price</div>
					  	<div class="col-xs-6">${listValue.price}</div>
					  	<div class="col-xs-12">
					  		<img class="card-image" src="${cdnUrl}/${listValue.image}">
					  	</div>
					</div>
				</div>
			</c:forEach>
		</c:if>
	</div>
</div>
