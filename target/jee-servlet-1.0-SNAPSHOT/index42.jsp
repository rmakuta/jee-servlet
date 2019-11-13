<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 13.11.2019
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="x" begin="2" end="10" step="2">
    <c:out value="${x}"/><p>
</c:forEach>
</body>
</html>
