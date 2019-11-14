<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 13.11.2019
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="someName" value="Witaj w coderslab."/>
<c:if test="${fn:contains(someName, 'coderslab')}" ><p>oK!</p></c:if>
</body>
</html>
