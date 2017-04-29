<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>  
<head>  
    <title>Spring Tiles Contact Form</title>  
</head>  
<body>  
<h2>Contact Manager</h2>
<table>  

<c:forEach items="${eList}" var="user">
    <tr>
        <td>Employee ID: <c:out value="${user.id}"/></td>
        <td>Employee Name: <c:out value="${user.name}"/></td>
        <td>Employee Pais: <c:out value="${user.country}"/></td>  
    </tr>
</c:forEach>
</table>
</body>  
</html>  