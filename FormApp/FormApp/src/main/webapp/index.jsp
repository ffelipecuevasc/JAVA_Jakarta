<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Map<String, String> errores = (Map<String, String>) request.getAttribute("errores"); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario Servlets</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
</head>
<body>
<h1>Formulario de usuarios</h1>
<div class="px-5">
    <form method="post" action="/FormApp/registro">
        <div class="row mb-3">
            <label for="usuario" class="col-form-label col-sm-2">Usuario: </label>
            <div class="col-sm-4"><input id="usuario" name="usuario" type="text" class="form-control"/></div>
            <% if (errores != null && errores.containsKey("Usuario")) { %>
            <div><div class="row mb-3 alert alert-danger col-sm-4" style="color:red"><%= errores.get("Usuario") %>
            </div></div>
            <% } %>
        </div>
        <div class="row mb-3">
            <label for="clave" class="col-form-label col-sm-2">Clave: </label>
            <div class="col-sm-4"><input id="clave" name="clave" type="password" class="form-control"/></div>
            <% if (errores != null && errores.containsKey("Clave")) { %>
            <div><div class="row mb-3 alert alert-danger col-sm-4" style="color:red"><%= errores.get("Clave") %>
            </div></div>
            <% } %>
        </div>
        <div class="row mb-3">
            <label for="email" class="col-form-label col-sm-2">Email:</label>
            <div class="col-sm-4"><input id="email" name="email" type="email" class="form-control"/></div>
            <% if (errores != null && errores.containsKey("Email")) { %>
            <div><div class="row mb-3 alert alert-danger col-sm-4" style="color:red"><%= errores.get("Email") %>
            </div></div>
            <% } %>
        </div>
        <div class="row mb-3">
            <label for="pais" class="col-form-label col-sm-2">Pais: </label>
            <div class="col-sm-4">
                <select id="pais" name="pais" class="form-select">
                    <option value="">Seleccione</option>
                    <option value="ES">España</option>
                    <option value="BR">Brasil</option>
                    <option value="CL">Chile</option>
                    <option value="AR">Argentina</option>
                </select>
            </div>
            <% if (errores != null && errores.containsKey("Pais")) { %>
            <div><div class="row mb-3 alert alert-danger col-sm-4" style="color:red"><%= errores.get("Pais") %>
            </div></div>
            <% } %>
        </div>
        <div class="row mb-3">
            <label for="lenguajes" class="col-form-label col-sm-2">Lenguajes:</label>
            <div class="col-sm-4">
                <select id="lenguajes" name="lenguajes" class="form-select" multiple>
                    <option value="">Seleccione</option>
                    <option value="Java">Java</option>
                    <option value="Python">Python</option>
                    <option value="JavaScript">JavaScript</option>
                    <option value="Php">Php</option>
                </select>
            </div>
            <% if (errores != null && errores.containsKey("Lenguaje")) { %>
            <div><div class="row mb-3 alert alert-danger col-sm-4" style="color:red"><%= errores.get("Lenguaje") %>
            </div></div>
            <% } %>
        </div>
        <div class="row mb-3">
            <label class="col-form-label col-sm-2">Rol:</label>
            <div class="form-check col-sm-2">
                <input type="checkbox" name="rol" id="rolAdmin" value="ADMIN" class="form-check-input"/>
                <label for="rolAdmin" class="form-check-label">Administrador</label>
            </div>
            <div class="form-check col-sm-2">
                <input type="checkbox" name="rol" id="rolUser" value="USER" class="form-check-input"/>
                <label for="rolUser" class="form-check-label">Usuario</label>
            </div>
            <div class="form-check col-sm-2">
                <input type="checkbox" name="rol" id="rolMod" value="MODERADOR" class="form-check-input"/>
                <label for="rolMod" class="form-check-label">Moderador</label>
            </div>
            <% if (errores != null && errores.containsKey("Rol")) { %>
            <div><div class="row mb-3 alert alert-danger col-sm-4" style="color:red"><%= errores.get("Rol") %>
            </div></div>
            <% } %>
        </div>
        <div class="row mb-3">
            <label class="col-form-label col-sm-2">Idiomas:</label>
            <div class="form-check col-sm-2">
                <input type="radio" name="idioma" id="idiomaES" value="ES" class="form-check-input"/>
                <label for="idiomaES" class="form-check-label">Español</label>
            </div>
            <div class="form-check col-sm-2">
                <input type="radio" name="idioma" id="idiomaEN" value="EN" class="form-check-input"/>
                <label for="idiomaEN" class="form-check-label">Inglés</label>
            </div>
            <div class="form-check col-sm-2">
                <input type="radio" name="idioma" id="idiomaBR" value="BR" class="form-check-input"/>
                <label for="idiomaBR" class="form-check-label">Portugués</label>
            </div>
            <% if (errores != null && errores.containsKey("Idioma")) { %>
            <div><div class="row mb-3 alert alert-danger col-sm-4" style="color:red"><%= errores.get("Idioma") %>
            </div></div>
            <% } %>
        </div>
        <div class="row mb-3">
            <label for="habilitar">Habilitar:</label>
            <div class="form-check col-sm-2">
                <input type="checkbox" id="habilitar" name="habilitar" checked class="form-check-input"/>
            </div>
        </div>
        <div>
            <input type="hidden" name="secreto" value="12345"/>
        </div>
        <div class="row mb-3">
            <div><input type="submit" value="Enviar" class="btn btn-primary"/></div>
        </div>
    </form>
</div>
</body>
</html>
