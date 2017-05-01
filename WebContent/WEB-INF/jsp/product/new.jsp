<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="row">
	<div class="col-xs-6 col-xs-offset-3">
		<form method="POST" 
			action="${contextPath}/product/new?${_csrf.parameterName}=${_csrf.token}" 
			enctype="multipart/form-data">
			
			<div class="form-group">
				<input  type="text" name="name" class="form-control" placeholder="Product Name"/>
            </div>
            
            <div class="form-group">
                <input type="file" name="imageFile" class="form-control" placeholder="Select image for product">
            </div>
            
            <div class="form-group">
            	<input type="number" name="price" class="form-control"
                            placeholder="Price">
            </div>
	 
			<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
		</form>
		
    	<h4 class="text-center"><a href="${contextPath}/index">Cancel</a></h4>
  	</div>
</div>