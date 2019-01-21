<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>BuutInvesto Details</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <style> <%@include file = "/WEB-INF/css/theme.css"%> </style>
</head>
<body>
<h2>BuutInvesto</h2>
<br>
<form:form action="${pageContext.request.contextPath}/get-recommendation" modelAttribute="emitent" method="POST">
    <input type="submit" value="Our Stock Recommendation"/>
</form:form>
<br>
<br>
<h3><c:out value="${emitent.emitentName}"/></h3>
<h3><c:out value="${emitent.emitentFullName}"/></h3>

<c:out value="${recommendation}"/>
<br>
<br>
<br>
Go back to <a href="${pageContext.request.contextPath}/search"> search page </a>
</body>
</html>
