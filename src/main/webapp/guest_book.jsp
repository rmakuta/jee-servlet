<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 18.11.2019
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/guest-book" method="post">
    <p>Tytuł: <input type="text" name="title">
       Wpis: <input type="text" name="description"">
        <input type="submit" value="Zapisz"></p>
</form>
<table>
    <c:forEach items="${posts}" var="post">
        <tr>
            <td>${post.title}</td>
            <td>${post.description}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
