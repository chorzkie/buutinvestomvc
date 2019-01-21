<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>BuutInvesto Recommendation Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <style> <%@include file = "/WEB-INF/css/theme.css"%> </style>
</head>
<body>
<h2>BuutInvesto Recommended Stocks</h2>
<br>
Go back to stock <a href="${pageContext.request.contextPath}/search"> search page </a>
<br>
<br>
<br>

<h3>Very Good Stocks</h3>
<table>
    <tr>
        <th>Company Full Name</th>
        <th><p>-------</p></th>
        <th>Emitent Code (Ticker)</th>
        <th><p>-------</p></th>
        <th> </th>
    </tr>
    <c:forEach var="emitent" items="${topEmitentsList}">

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


<br>
<br>
<br>
<h3>Good Stocks</h3>
<table>
    <tr>
        <th>Company Full Name</th>
        <th><p>-------</p></th>
        <th>Emitent Code (Ticker)</th>
        <th><p>-------</p></th>
        <th> </th>
    </tr>
    <c:forEach var="emitent" items="${goodEmitentsList}">

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
