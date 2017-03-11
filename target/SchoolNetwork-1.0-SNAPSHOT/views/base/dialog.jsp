<%--
  Created by IntelliJ IDEA.
  User: ваня
  Date: 08.03.2017
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="message" items="${messages}">
    ${message.message}
</c:forEach>
</body>
</html>
