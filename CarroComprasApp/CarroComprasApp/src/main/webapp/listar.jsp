<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="plantilla/encabezado.jsp"/>
<div class="container py-5">
    <div class="container">
        <h1 class="mb-3 text-center">Listado de Productos</h1>
        <c:if test="${requestScope.username.isPresent()}">
            <div class="container p-3 border rounded-2 bg-light d-flex justify-content-between align-items-center">
                <p class="mb-0">Bienvenido '<c:out value="${requestScope.username.get()}"/>', acá podrás gestionar productos.</p>
                <a class="btn btn-dark text-light" href="/CarroComprasApp/form/producto">Crear productos</a>
            </div>
        </c:if>
    </div>
    <div class="container p-4">
        <table class="table table-striped table-hover border">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Tipo</th>
                <c:if test="${requestScope.username.isPresent()}">
                    <th>Precio</th>
                    <th>Editar</th>
                    <th>Eliminar</th>
                    <th>Agregar al Carro</th>
                </c:if>
            </tr>
            <c:forEach items="${requestScope.productos}" var="p">
                <tr>
                    <td><c:out value="${p.getId()}"/></td>
                    <td><c:out value="${p.getNombre()}"/></td>
                    <td><c:out value="${p.getTipo()}"/></td>
                    <c:if test="${requestScope.username.isPresent()}">
                        <td><c:out value="${p.getPrecio()}"/></td>
                        <td><a class="btn btn-primary btn-sm"
                               href="/CarroComprasApp/form/producto?id=<c:out value="${p.getId()}"/>">Editar</a></td>
                        <td><a class="btn btn-danger btn-sm"
                               href="/CarroComprasApp/form/producto/eliminar?id=<c:out value="${p.getId()}"/>">Eliminar</a>
                        </td>
                        <td><a class="btn btn-success btn-sm"
                               href="/CarroComprasApp/carro/agregar?id=<c:out value="${p.getId()}"/>">Agregar al
                            Carro</a></td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<jsp:include page="plantilla/pie.jsp"/>