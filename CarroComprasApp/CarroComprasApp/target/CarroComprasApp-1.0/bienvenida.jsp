<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="plantilla/encabezado.jsp"/>
<div class="container py-5">
    <h1 class="mb-3 text-center">Inicio de Sesión</h1>
    <p class="lead text-center mb-4">¡Inicio de Sesión Exitoso! Bienvenido '<c:out
            value="${requestScope.username.get()}"/>'</p>
</div>
<jsp:include page="plantilla/pie.jsp"/>