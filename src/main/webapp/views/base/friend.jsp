<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Title</title>
</head>
<div class="container">
    <div class="row">
        <c:forEach var="user" items="${users}">
            <a href="/profile/${user.id}">${user.firstName} ${user.secondName}</a> <br>
        </c:forEach>
    </div>
</div>

