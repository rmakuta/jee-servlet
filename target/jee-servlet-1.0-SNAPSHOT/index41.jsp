<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 13.11.2019
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty param.foo}">
    <p>Wybrany autor: ${param.foo}</p>
</c:if>
</body>
</html>
