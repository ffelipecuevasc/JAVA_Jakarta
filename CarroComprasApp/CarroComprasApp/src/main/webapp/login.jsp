<%@page contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>
<jsp:include page="plantilla/encabezado.jsp" />
    <div class="container d-flex flex-column align-items-center mt-5">
        <h1 class="mb-4 text-center">Iniciar sesión</h1>
        <div class="p-4 border rounded shadow" style="max-width: 500px; width: 100%">
            <form action="/CarroComprasApp/login" method="post">
                <div class="mb-3">
                    <label for="username" class="col-form-label">Usuario: </label>
                    <input type="text" name="username" id="username" class="form-control">
                </div>
                <div class="mb-3">
                    <label for="password" class="col-form-label">Clave: </label>
                    <input type="password" name="password" id="password" class="form-control">
                </div>
                <div class="mb-3 text-center">
                    <button type="submit" class="btn btn-primary">Iniciar Sesión</button>
                </div>
            </form>
        </div>
    </div>
<jsp:include page="plantilla/pie.jsp" />