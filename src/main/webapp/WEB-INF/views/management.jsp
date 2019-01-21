<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>BuutInvesto Management Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <style> <%@include file = "/WEB-INF/css/theme.css"%> </style>
</head>
<body>

<h2> BuutInvesto Management Page </h2>
<br>
Go to recommendation and stock search page <a href="${pageContext.request.contextPath}/search"> for subscribers </a>
<br>
<br>
<br>
<form:form method="POST" action="${pageContext.request.contextPath}/add-emitent" modelAttribute="emitent">
    <form:input type="hidden" path="id" />
    Ticker Name: <br/>
    <form:input path="emitentName" type="text"/> <br/>
    <br>
    URL Path <br/>
    <form:input path="emitentURL" type="text"/> <br/>
    <br>
    <input type="submit" value="Add This Company To Database"/>
</form:form>


<br>
<br>
    <form:form action="${pageContext.request.contextPath}/search-manage-emitent" modelAttribute="emitent" method="POST">
        <label>Search emitents to manage: </label> <input type="text" name="searchValue" placeholder="Search emitents" />
        <input type="submit" value="Search" />
    </form:form>
<br>
<table>
<tr>
<td>
<form:form action="${pageContext.request.contextPath}/list-emitent" modelAttribute="emitent" method="GET">

    <input type="submit" value="List Down All Emitents" />

</form:form>
</td>
<td>
<form:form action="${pageContext.request.contextPath}/update-all-recommendation" modelAttribute="emitent" method="GET">

    <input type="submit" value="Update Stock Recommendation List" onclick = "if (!(confirm('Are you sure you want to update recommendation list?'))) return false" />

</form:form>
</td>
<td>
<form:form action="${pageContext.request.contextPath}/update-all-emitent" modelAttribute="emitent" method="GET">

    <input type="submit" value="Update Fundamentals Data of All Emitents" onclick = "if (!(confirm('Are you sure you want to update all emitents data?'))) return false" />

</form:form>
</td>
</tr>
</table>
<br>
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

        <c:url var="getUpdate" value="get-update-form">
            <c:param name="emitentId" value="${emitent.id}" />
        </c:url>

        <tr>
            <td>${emitent.emitentFullName}</td>
            <td><p>-------</p></td>
            <td>${emitent.emitentName}</td>
            <td><p>-------</p></td>
            <td> View details or edit this emitent <a href="${getUpdate}">  manually</a> </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
