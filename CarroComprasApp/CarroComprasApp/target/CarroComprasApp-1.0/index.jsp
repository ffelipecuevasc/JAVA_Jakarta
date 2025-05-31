<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="plantilla/encabezado.jsp" />
    <div class="container py-5">
        <h1 class="mb-3 text-center">Aplicación Web - Carro de Compras</h1>
        <p class="lead text-center mb-4">Aplicación web que simula el despliegue de productos y la compra de los mismos en un carro de compras.</p>
    <div class="row justify-content-center">
        <div class="col-md-6">
            <ul class="list-group custom-hover">
                <li class="list-group-item bg-light"><a class="text-decoration-none d-block" href="/CarroComprasApp/login">Iniciar Sesión</a></li>
                <li class="list-group-item bg-light"><a class="text-decoration-none d-block" href="/CarroComprasApp/logout">Cerrar Sesión</a></li>
                <li class="list-group-item bg-light"><a class="text-decoration-none d-block" href="/CarroComprasApp/productos">Mostrar Productos</a></li>
                <li class="list-group-item bg-light"><a class="text-decoration-none d-block" href="/CarroComprasApp/carro.jsp">Ver Carro de Compras</a></li>
            </ul>
        </div>
    </div>
    </div>
<jsp:include page="plantilla/pie.jsp" />