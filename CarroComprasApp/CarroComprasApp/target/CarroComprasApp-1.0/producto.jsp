<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="plantilla/encabezado.jsp"/>
<div class="container d-flex flex-column align-items-center mt-3">
    <h1 class="mb-4 text-center">Formulario de productos</h1>
    <c:if test="${requestScope.errores != null}">
        <div class="container bg-danger">
            <h5 class="text-light">Listado de errores</h5>
            <ul class="list-group">
                <c:forEach items="${requestScope.errores.values()}" var="error">
                    <li class="list-group-item"><c:out value="${error}"/></li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    <div class="p-4 border rounded shadow" style="max-width: 500px; width: 100%">
        <form method="post" action="/CarroComprasApp/form/producto">
            <div class="mb-3">
                <label for="nombre" class="col-form-label">Nombre: </label>
                    <input id="nombre" name="nombre" type="text" class="form-control"
                           value="<c:out value="${requestScope.producto.getNombre()}"/>"/>
            </div>
            <div class="mb-3">
                <label for="tipo" class="col-form-label">Tipo: </label>
                    <input id="tipo" name="tipo" type="text" class="form-control"
                           value="<c:out value="${requestScope.producto.getTipo()}"/>"/>
            </div>
            <div class="mb-3">
                <label for="precio" class="col-form-label">Precio: </label>
                    <input id="precio" name="precio" type="text" class="form-control"
                           value="<c:out value="${requestScope.producto.getPrecio()}"/>"/>
            </div>
            <input type="hidden" name="id"
                   value="<c:out value="${requestScope.producto.getId()}"/>"/>
            <div class="mb-3 text-center">
                <button type="submit" class="btn btn-primary">
                    <c:out value="${(requestScope.producto.getId() != null) && (requestScope.producto.getId() > 0) ? 'Editar' : 'Crear'}"/>
                </button>
            </div>
        </form>
    </div>
</div>
<jsp:include page="plantilla/pie.jsp"/>