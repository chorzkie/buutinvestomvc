<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>BuutInvesto Search</title>
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
    <form:form action="${pageContext.request.contextPath}/search-emitent" modelAttribute="emitent" method="POST">
        <label>Search stock or company name here: </label> <input type="text" name="searchValue" placeholder="Search stock or company" />
        <input type="submit" value="Search" />
    </form:form>
<br>

<table>
    <tr>
        <th>Company Full Name</th>
        <th><p>-------</p></th>
        <th>Emitent Code (Ticker)</th>
        <th><p>-------</p></th>
        <th> </th>
    </tr>
    <c:forEach var="emitent" items="${emitentsList}">

        <c:url var="getDetail" value="unit-detail">
            <c:param name="emitentId" value="${emitent.id}" />
        </c:url>

    <tr>
        <td>${emitent.emitentFullName}</td>
        <td><p>-------</p></td>
        <td>${emitent.emitentName}</td>
        <td><p>-------</p></td>
        <td><a href="${getDetail}"> See our opinion about this emitent </a> </td>
    </tr>

    </c:forEach>
</table>


</body>
</html>
