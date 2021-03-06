<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="row">
	<div class="col-xs-6 col-xs-offset-3">
		<form method="POST" action="${contextPath}/login" class="form-signin">
	      <h2 class="form-heading">Log in</h2>
	
	      <div class="form-group ${error != null ? 'has-error' : ''}">
	          <span>${message}</span>
	          <input name="username" type="text" class="form-control" placeholder="Username"
	                 autofocus="true"/>
          </div>
          <div class="form-group ${error != null ? 'has-error' : ''}">
              <input name="password" type="password" class="form-control" placeholder="Password"/>
	          <span>${error}</span>
	          
			  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
          </div>
          <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
          <h4 class="text-center"><a href="${contextPath}/register">Create an account</a></h4>
	  	</form>
	</div>
</div>