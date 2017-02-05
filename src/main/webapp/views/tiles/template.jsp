<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<head>
    <title>SchoolBook</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
</head>
<body>
<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="body" />
<tiles:insertAttribute name="footer"/>
<script src = "/js/bootstrap.js"></script>
</body>
</html>
