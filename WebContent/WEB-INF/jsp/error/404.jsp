<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<div class="row">
	<div class="col-xs-6 col-xs-offset-3 text-center">
		<h2>
			The page you requested does
			not exists.
		</h2>
	</div>
	<div class="col-xs-3 col-xs-offset-3">
		<h4 class="text-center">
			<a href="${contextPath}/login">Login</a>
		</h4>
	</div>
	<div class="col-xs-3">
		<h4 class="text-center">
			<a href="${contextPath}/index">Index</a>
		</h4>
	</div>
</div>