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
	<div class="col-xs-offset-2 col-xs-8">
		<c:choose>
		    <c:when test="${not empty products}">
		        <c:forEach var="listValue" items="${products}">
		        	<div class="col-xs-4 panel panel-primary">
						<div class="panel-heading">
						  	<h3 class="panel-title">${listValue.name}</h3>
						</div>
						<div class="panel-body">
						  	<div class="col-xs-6">Price</div>
						  	<div class="col-xs-6">$ ${listValue.price}</div>
						  	<div class="col-xs-12">
						  		<img class="card-image center-block" src="${cdnUrl}/${listValue.image}">
						  	</div>
						  	<c:if test="${listValue.sold == true}">
						  		<div class="col-xs-4 col-xs-offset-4 space-top">
						  			<a href="#" class="btn btn-danger disabled">SOLD</a>
						  		</div>
						  	</c:if>
						  	<c:if test="${listValue.sold == false}">
						  		<div class="col-xs-4 col-xs-offset-4 space-top">
						  			<a href="#" class="btn btn-success disabled">FOR SALE</a>
						  		</div>
						  	</c:if>
						</div>
					</div>
				</c:forEach>
		    </c:when>    
		    <c:otherwise>
		       <h2 class="text-center">Nothing published yet</h2>
		    </c:otherwise>
		</c:choose>
	</div>
</div>
<h4 class="text-center">
	<a href="${contextPath}/index">Back</a>
</h4>