<%-- 
    Se va a mostrar como guardar lo valores que se ingresaon en el formulario, es decir
    antes cuando se daba click en enviar, si exitian errores en el formulario, entonce
    regresaba al formulario pero todos los campos estaban en blanco, ahora los
    campos van a tener los valores

    Para hacer esto vamos a usa las variables param las cules son los valores que estan
    dentro de request.getAttribute("") (en este caso es errores pero puede ser otra variable)
    dentro de param estan las variables que queremos y accedemos a ellas con parama.NombreVariable
    por ejemplo param.username
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
        <link href=<%=request.getContextPath()%>/css/bootstrap.min.css rel="stylesheet" >
    </head>
    <body class="px-2">
        <h1>Llenar el formuario (06_GuardandoValoresForm.jsp): </h1>
        
        <div class="px-5 py-4">
            <form action="/05_Jakarta_02_webapp-form/valoresGuardados" method="post">
                <div class="row mb-3">
                    <label for="username" class="col-form-label col-sm-2">Username</label>
                    <div class="col-sm-4">
                        <input type="text" name="username" id="username" class="form-control" value="${param.username}">
                    </div>
                    <div> 
                        <%
                            if (errores != null && errores.containsKey("username")) {
                                out.println("<div class='alert alert-danger row-sm-4 style='color:red;'>" + errores.get("username") + "</small>");
                            }
                        %>
                    </div>
                    <!-- 
                        se agrego un ejemplo de como poner el mensaje de error, abajo y no al lado, basicamente 
                        se saca el error a un div el cual se pone abajo del campo, y se cambian las el contenido en lugar de
                        small se pone div y en lugar de col se pone row
                    -->
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
                    <div class="col-sm-4"><input type="email" name="email" id="email" class="form-control" value="${param.email}"></div>
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
                            <option value="">-- Seleccionar --</option>
                            <option value="es" value="${param.pais.equals("es")?"selected":""}">España</option>
                            <option value="mx" value="${param.pais.equals("mx")?"selected":""}">México</option>
                            <option value="cl" value="${param.pais.equals("cl")?"selected":""}">Chile</option>
                            <option value="ar" value="${param.pais.equals("ar")?"selected":""}">Argentina</option>
                            <option value="pe" value="${param.pais.equals("pe")?"selected":""}">Perú</option>
                            <option value="co" value="${param.pais.equals("co")?"selected":""}">Colombia</option>
                            <option value="ve" value="${param.pais.equals("ve")?"selected":""}">Venezuela</option>
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
                    <div class="form-check col-sm-3" >
                        <input type="checkbox" name="roles" value="ROLE_ADMIN" class="form-check-input">
                        <label class="form-label-check">Administrador</label>
                    </div>
                    <div class="form-check col-sm-3">
                        <input type="checkbox" name="roles" value="ROLE_USER" class="form-check-input">
                        <label class="form-label-check">Usuario</label>
                    </div>
                    <div class="form-check col-sm-3">
                        <input type="checkbox" name="roles" value="ROLE_MODERATOR" class="form-check-input">
                        <label class="form-label-check">Moderador</label>
                    </div>
                    <%
                        if (errores != null && errores.containsKey("roles")) {
                            out.println("<small class='alert alert-danger col-sm-4 style='color:red;'>" + errores.get("roles") + "</small>");
                        }
                    %>
                </div>

                <div class="row mb-3">
                    <label class="col-form-label col-sm-2">Idiomas</label>
                    <div class="form-check col-sm-3">
                        <input type="radio" name="idioma" value="es" class="form-check-input" value="${param.idioma.equals("es")?"checked":""}">
                        <label class="form-check-label">Español</label>
                    </div>
                    <div class="form-check col-sm-3">
                        <input type="radio" name="idioma" value="en" class="form-check-input" value="${param.idioma.equals("en")?"checked":""}>
                        <label class="form-check-label">Ingles</label>
                    </div>
                    <div class="form-check col-sm-3">
                        <input type="radio" name="idioma" value="fr" class="form-check-input" value="${param.idioma.equals("fr")?"checked":""}>
                        <label class="form-check-label">Frances</label>
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

