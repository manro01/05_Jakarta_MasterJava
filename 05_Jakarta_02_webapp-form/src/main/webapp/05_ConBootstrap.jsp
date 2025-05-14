<%-- 
    Aquí solo se va a mostrar como usar Bootstrap para que se vea un poco mejor
    pero la programación es la misma que el anterior

    Para usar Bootstrap en linea hay que coloca esta linea en el segmento <head>,
        se recomineda despues del titulo de la ventana.
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    Map<String, String> errores= (Map<String, String>)request.getAttribute("errores");
    //NOTAS
    //request es parte del servlet, por lo tanto viene integrado
    //getAttribute, agarra un atributo, para esto el atributo debe existir, en este caso erroes, lo definimos en el Servlet03
    //  hay que verificar que el nombre sea el mismo
    //request regresa tipo Object por lo que hay que hacer un cast a List<String>
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Datos ingresados </title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    </head>
    <body class="px-2">
        <h1>Llenar el formuario (05_ConBootstrap.jsp): </h1>
        
        <div class="px-5 py-4">
            <!-- recuerda que esto /formErroresEnMismoForm es la ruta que le dimos al Servlet04_ValidacionDebajoDelCampo-->
            <form action="/05_Jakarta_02_webapp-form/conBootsrap" method="post">
                <div class="row mb-3">
                    <label for="username" class="col-form-label col-sm-2">Username</label>
                    <div class="col-sm-4"><input type="text" name="username" id="username" class="form-control"></div>
                        <%
                            if (errores != null && errores.containsKey("username")) {
                                out.println("<small class='alert alert-danger col-sm-4 style='color:red;'>" + errores.get("username") + "</small>");
                            }
                        %>
                </div>
                <div class="row mb-3">
                    <label for="password" class="col-form-label col-sm-2">Pasword</label>
                    <div class="col-sm-4"><input type="password" name="password" id="password" class="form-control"></div>
                        <%
                            if (errores != null && errores.containsKey("password")) {
                                out.println("<small class='alert alert-danger col-sm-4 style='color:red;'>" + errores.get("password") + "</small>");
                            }
                        %>
                </div>
                <div class="row mb-3">
                    <label for="email" class="col-form-label col-sm-2">Email</label>
                    <div class="col-sm-4"><input type="email" name="email" id="email" class="form-control"></div>
                        <%
                            if (errores != null && errores.containsKey("email")) {
                                out.println("<small class='alert alert-danger col-sm-4 style='color:red;'>" + errores.get("email") + "</small>");
                            }
                        %>
                </div>

                <br>
                <div class="row mb-3">
                    <label for="pais" class="col-form-label col-sm-2">País</label>
                    <div class="col-sm-4">
                        <select name="pais" id="pais" class="form-select">
                            <option value="" selected>-- Seleccionar --</option>
                            <option value="es">España</option>
                            <option value="mx">México</option>
                            <option value="cl">Chile</option>
                            <option value="ar">Argentina</option>
                            <option value="pe">Perú</option>
                            <option value="co">Colombia</option>
                            <option value="ve">Venezuela</option>
                        </select>
                    </div>
                    <%
                        if (errores != null && errores.containsKey("pais")) {
                            out.println("<small class='alert alert-danger col-sm-4 style='color:red;'>" + errores.get("pais") + "</small>");
                        }
                    %>
                </div>

                <br>
                <div class="row mb-3">
                    <label for="lenguajes" class="col-form-label col-sm-2">Lenguajes de programación</label>
                    <div class="col-sm-4">
                        <select name="lenguajes" id="lenguajes" multiple class="form-select">
                            <option value="java">Java SE</option>
                            <option value="jakarta">Jakarta EE9</option>
                            <option value="spring">Spring Boot</option>
                            <option value="js">Javascript</option>
                            <option value="angular">Angular</option>
                            <option value="react">React</option>
                        </select>
                    </div>
                    <%
                        if (errores != null && errores.containsKey("lenguajes")) {
                            out.println("<small class='alert alert-danger col-sm-4 style='color:red;'>" + errores.get("lenguajes") + "</small>");
                        }
                    %>
                </div>

                <br>
                <div class="row mb-3">
                    <label class="col-form-label col-sm-2">Roles</label> 
                    <div class="col-sm-4">
                        <div class="form-check">
                            <input type="checkbox" name="roles" value="ROLE_ADMIN" class="form-check-input">
                            <label>Administrador</label>
                        </div>
                        <div class="form-check">
                            <input type="checkbox" name="roles" value="ROLE_USER" class="form-check-input">
                            <label>Usuario</label>
                        </div>
                        <div class="form-check">
                            <input type="checkbox" name="roles" value="ROLE_MODERATOR" class="form-check-input">
                            <label>Moderador</label>
                        </div>
                    </div>
                    <%
                        if (errores != null && errores.containsKey("roles")) {
                            out.println("<small class='alert alert-danger col-sm-4 style='color:red;'>" + errores.get("roles") + "</small>");
                        }
                    %>
                </div>

                <div class="row mb-3">
                    <label class="col-form-label col-sm-2">Idiomas</label>
                    <div class="col-sm-4">
                        <div class="form-check">
                            <input type="radio" name="idioma" value="es" class="form-check-input">
                            <label class="form-check-label">Español</label>
                        </div>
                        <div class="form-check">
                            <input type="radio" name="idioma" value="en" class="form-check-input">
                            <label class="form-check-label">Ingles</label>
                        </div>
                        <div class="form-check">
                            <input type="radio" name="idioma" value="fr" class="form-check-input">
                            <label class="form-check-label">Frances</label>
                        </div>
                    </div>
                    <%
                        if (errores != null && errores.containsKey("idioma")) {
                            out.println("<small class='alert alert-danger col-sm-4 style='color:red;'>" + errores.get("idioma") + "</small>");
                        }
                    %>
                </div>

                <div class="row mb-3">
                    <label for="habilitar" class="col-form-label col-sm-2">Habilitar</label>
                    <div class="col-sm-4">
                        <div class="form-check">
                        <input type="checkbox" name="habilitar" id="habilitar" checked="" class="form-check-input">
                    </div>
                    </div>
                </div>

                <input type="hidden" name="secreto" value="12345">            
                <br>
                <div class="row mb-3">
                    <div>
                        <input type="submit" value="Enviar" class="btn btn-primary">
                    </div>
                </div>
            </form>
        </div>               
    </body>
    
    <footer>
        <br>
        <a href="index.html">Regresar al inicio</a>
    </footer>
</html>

