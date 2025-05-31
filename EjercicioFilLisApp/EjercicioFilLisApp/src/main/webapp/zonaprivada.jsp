<%--
  Created by IntelliJ IDEA.
  User: ffeli
  Date: 19-05-2025
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = (String) request.getSession().getAttribute("username");
%>
<html>
<head>
    <title>Zona Privada</title>
</head>
<body>
    <h1>Zona Privada</h1>
    <h4>Bienvenido <%= username %>.</h4>
</body>
</html>
