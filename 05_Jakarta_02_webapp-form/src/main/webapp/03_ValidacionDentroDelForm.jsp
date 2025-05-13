<%-- 
    Document   : 03_ValidacionDentroDelForm
    Created on : 13 may 2025, 13:54:00
    Author     : manuel

    En este caso el form ya no es un html, se hizo un jsp el jsp permite intercalar código java
        en un html, con esto podemos "programar" comportamiento de una página

    Los scriptlet son partes de código java que se ponen en un jsp, este código tiene 
        que estar entre <% código %>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>

<% 
    List<String> errores= (List<String>)request.getAttribute("errores");
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
    </head>
    <body>
        <h1>Llenar el formuario (03_ValidacionDentroDelForm.jsp): </h1>
        
        <%
            if(errores!=null && errores.size()>0)
            {
        %>
        
        <ul>
            <%for(String error: errores) { %>
            <li><%=error  %></li>  <!<!-- se puedo haber usado out.printl(error); -->
            
            <% } %>
        </ul>
        
        <%
        
            }
        %>
        
        <!<!-- recuerda que esto /formErroresEnMismoForm es la ruta que le dimos al Servlet03_FormErroresEnMismoForm-->
        <form action="/05_Jakarta_02_webapp-form/formErroresEnMismoForm" method="post">
            <div>
                <label for="username">Username</label>
                <div><input type="text" name="username" id="username"></div>
            </div>
            <div>
                <label for="password">Pasword</label>
                <div><input type="password" name="password" id="password"></div>
            </div>
            <div>
                <label for="email">Email</label>
                <div><input type="email" name="email" id="email"></div>
            </div>
            
            <br>
            <div>
                <label for="pais">País</label>
                <div>
                    <select name="pais" id="pais">
                        <option value="">-- Seleccionar --</option>
                        <option value="es">España</option>
                        <option value="mx" selected>México</option>
                        <option value="cl">Chile</option>
                        <option value="ar">Argentina</option>
                        <option value="pe">Perú</option>
                        <option value="co">Colombia</option>
                        <option value="ve">Venezuela</option>
                    </select>
                </div>
            </div>
            
            <br>
            <div>
                <label for="lenguajes">Lenguajes de programación</label>
                <div>
                    <select name="lenguajes" id="lenguajes" multiple>
                        <option value="java">Java SE</option>
                        <option value="jakarta">Jakarta EE9</option>
                        <option value="spring">Spring Boot</option>
                        <option value="js">Javascript</option>
                        <option value="angular">Angular</option>
                        <option value="react">React</option>
                    </select>
                </div>
            </div>
            
            <br>
            <div>
                <label>Roles</label> 
                <div>
                    <input type="checkbox" name="roles" value="ROLE_ADMIN">
                    <label>Administrador</label>
                </div>
                <div>
                    <input type="checkbox" name="roles" value="ROLE_USER">
                    <label>Usuario</label>
                </div>
                <div>
                    <input type="checkbox" name="roles" value="ROLE_MODERATOR">
                    <label>Moderador</label>
                </div>
            </div>
            
            <div>
                <label>Idiomas</label>
                <div>
                    <input type="radio" name="idioma" value="es">
                    <label>Español</label>
                </div>
                <div>
                    <input type="radio" name="idioma" value="en">
                    <label>Ingles</label>
                </div>
                <div>
                    <input type="radio" name="idioma" value="fr">
                    <label>Frances</label>
                </div>
            </div>
            
            <div>
                <label for="habilitar">Habilitar</label>
                <div>
                    <input type="checkbox" name="habilitar" id="habilitar" checked="">
                </div>
            </div>
            
            <input type="hidden" name="secreto" value="12345">            
            <br>
            <div>
                <div>
                    <input type="submit" value="Enviar">
                </div>
            </div>
        </form>
    </body>
    
    <footer>
        <br>
        <a href="index.html">Regresar al inicio</a>
    </footer>
</html>

