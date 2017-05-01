<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
"http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
	<title>
		<tiles:insertAttribute name="title" ignore="true" />
	</title>
	<link href="<c:url value="/resources/css/theme.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/layout.css" />" rel="stylesheet">
</head>
<body>  
        <div>
        	<tiles:insertAttribute name="header" />
       	</div>
       	<div>
       		<tiles:insertAttribute name="body" />
       	</div>
       	<div style="clear:both">
        	<tiles:insertAttribute name="footer" />
   		</div>
</body>  
</html>  