<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<spring:eval expression="@propertyConfigurer.getProperty('project.cdnUrl')" var="cdnUrl" />

<div class="row">
	<div class="text-center">
		<h2>Your transactions</h2>
	</div>
</div>
<div class="row">
	<div class="col-xs-offset-2 col-xs-8">
		<c:choose>
		    <c:when test="${not empty transactions}">
		    	<table class="table table-striped table-hover ">
		    	<thead>
				    <tr>
				      <th>#</th>
				      <th>Product Name</th>
				      <th>Buyer</th>
				      <th>Seller</th>
				      <th>State</th>
				    </tr>
			  	</thead>
			  	<tbody>
			        <c:forEach var="listValue" items="${transactions}">
			        	<c:choose>
			        		<c:when test="${listValue.buyer.username == currentUser.username}">
			        			<tr class="info">
			        				<td>${listValue.id}</td>
							      	<td>${listValue.product.name}</td>
							      	<td>${listValue.buyer.username}</td>
							      	<td>${listValue.seller.username}</td>
							      	<td>Bought</td>
							    </tr>
			        		</c:when>
			        		<c:otherwise>
			        			<tr class="success">
			        				<td>${listValue.id}</td>
							      	<td>${listValue.product.name}</td>
							      	<td>${listValue.buyer.username}</td>
							      	<td>${listValue.seller.username}</td>
							      	<td>Sold</td>
							    </tr>
			        		</c:otherwise>
			        	</c:choose>			        	
					</c:forEach>
				</tbody>
				</table>
		    </c:when>    
		    <c:otherwise>
		       <h2 class="text-center">No transactions yet</h2>
		    </c:otherwise>
		</c:choose>
	</div>
</div>
<h4 class="text-center">
	<a href="${contextPath}/index">Back</a>
</h4>