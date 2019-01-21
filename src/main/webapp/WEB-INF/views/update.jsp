<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>BuutInvesto Emitent Details</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <style> <%@include file = "/WEB-INF/css/theme.css"%> </style>
</head>
<body>

<h2> Emitent Details Page </h2>
<br>
<a href="${pageContext.request.contextPath}/"> Back to management page </a>
<br>
<br>
<h3> Update Emitent Details Manually Below </h3>
<form:form method="POST" action="${pageContext.request.contextPath}/updateEmitent" modelAttribute="emitent">
    <form:input type="hidden" path="id" />
    Ticker Name: <br/>
    <form:input path="emitentName" type="text"/> <br/>
    <br>
    URL Path: <br/>
    <form:input path="emitentURL" type="text"/> <br/>
    <br>
    Company Full Name: <br/>
    <form:input path="emitentFullName" type="text"/> <br/>
    <br>
    Return of Equity (ROE) Value: <br/>
    <form:input path="fundamental.roe" type="number" placeholder="1.00" step="0.01" min="-1000" max="1000"/> <br/>
    <br>
    Price Booked Value (PBV): <br/>
    <form:input path="fundamental.pbv" type="number" placeholder="1.00" step="0.01" min="-1000" max="1000"/> <br/>
    <br>
    Price to Equity Ratio (PER) Value :<br/>
    <form:input path="fundamental.per" type="number" placeholder="1.00" step="0.01" min="-1000" max="1000"/> <br/>
    <br>
    Last 5 Years Sales Growth Rate (%): <br/>
    <form:input path="fundamental.sales5" type="number" placeholder="1.00" step="0.01" min="-1000" max="1000"/> <br/>
    <br>
    Last 5 Years Earning Per Share (EPS) Growth Rate (%): <br/>
    <form:input path="fundamental.eps5" type="number" placeholder="1.00" step="0.01" min="-1000" max="1000"/> <br/>
    <br>
    <input type="submit" value="Update Details"/>
</form:form>


<br>
<br>

<form:form method="POST" action="${pageContext.request.contextPath}/deleteEmitent" modelAttribute="emitent">
    <input type="hidden" value="${emitent.id}" name="delete"/>
    <input type="submit" value="Delete This Emitent" onclick = "if (!(confirm('Are you sure to delete this emitent?'))) return false" />
</form:form>

</body>
</html>
