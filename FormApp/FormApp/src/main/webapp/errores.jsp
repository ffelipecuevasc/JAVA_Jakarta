<%--
  Created by IntelliJ IDEA.
  User: ffeli
  Date: 09-05-2025
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Errores</title>
</head>
<body>
    <h1>Recepción de Errores</h1>
    <div>
        <ul>
            <%
                List<String> errores = (List<String>) request.getAttribute("errores");
                for(String error : errores){ %>
                <li><%= error%></li>
            <% } %>
        </ul>
    </div>
</body>
</html>
