<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 14.11.2019
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>newsletter</title>
</head>
<body>
<p>"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
    Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
    Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
    Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."</p>
<c:choose>
    <c:when test="${not empty cookie.user}">

    </c:when>
    <c:otherwise>
        <form action="/newsletter" method="post">
            <p>email: <input type="text" name="email">
                name: <input type="text" name="name">
                <input type="submit" value="Zapisz"></p>
        </form>
    </c:otherwise>
</c:choose>
</body>
</html>
