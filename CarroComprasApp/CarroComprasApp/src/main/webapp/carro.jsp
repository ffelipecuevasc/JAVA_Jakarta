<%@ page contentType="text/html;charset=UTF-8" language="java" import="org.fcuevas.carro.modelo.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="plantilla/encabezado.jsp"/>
<div class="container py-5">
    <div class="container">
        <h1 class="mb-3 text-center">Carro de Compras</h1>
        <c:choose>
            <c:when test="${carro.getItems().isEmpty()}">
                <div class="p-4 border rounded shadow bg-warning d-flex justify-content-center align-items-center">
                    <p class="mb-0 text-center">Lo sentimos, no hay productos en el carro de compras.</p>
                </div>
            </c:when>
            <c:otherwise>
                <div class="container pd-3">
                    <table class="table table-hover table-striped border">
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Precio</th>
                            <th>Cantidad</th>
                            <th>Total</th>
                        </tr>
                        <c:forEach items="${carro.getItems()}" var="itemCarro">
                            <tr>
                                <td><c:out value="${itemCarro.getProducto().getId()}"/></td>
                                <td><c:out value="${itemCarro.getProducto().getNombre()}"/></td>
                                <td><c:out value="${itemCarro.getProducto().getPrecio()}"/></td>
                                <td><c:out value="${itemCarro.getCantidad()}"/></td>
                                <td><c:out value="${itemCarro.getTotal()}"/></td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td colspan="4" style="text-align: right">Total del Carro</td>
                            <td><c:out value="${carro.getTotal()}"/></td>
                        </tr>
                    </table>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<jsp:include page="plantilla/pie.jsp"/>