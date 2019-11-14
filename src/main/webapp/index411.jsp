<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 14.11.2019
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="${not empty cookie.language}">
        <p>${cookie.language.value}</p>
    </c:when>
    <c:otherwise>
        <p>Cześć!</p>
    </c:otherwise>
</c:choose>
<form action="/servlet412" method="post">
    <select name="language">
        <c:forEach var="lang" items="${languages}">
            <option value='${lang.getValue()}'>${lang.getValue()}</option>
        </c:forEach>
    </select>
    <input type='submit' value='prześlij'>
</form>
</body>
</html>
