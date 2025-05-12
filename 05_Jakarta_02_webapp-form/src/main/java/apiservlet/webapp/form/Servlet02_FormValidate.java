/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package apiservlet.webapp.form;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author manuel
 */
@WebServlet(name = "Servlet02_FormValidate", urlPatterns = {"/formValidate"})
public class Servlet02_FormValidate extends HttpServlet 
{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
    {
        res.setContentType("text/html;charset=UTF-8");
        
        String username= req.getParameter("username");
        String password= req.getParameter("password");
        String email= req.getParameter("email");
        String pais= req.getParameter("pais");
        String[] lenguajes= req.getParameterValues("lenguajes");
        String[] roles= req.getParameterValues("roles");
        String idioma= req.getParameter("idioma");
        String habilitar= req.getParameter("habilitar");
        String secreto= req.getParameter("secreto");
        
        List<String> errores= new ArrayList<>();
        
        if(username== null || username.isBlank())
        {
            errores.add("El username es requerido");
        }
        if(password== null || password.isBlank())
        {
            errores.add("El password no puede ser vacío");
        }
        if(email.isBlank())
        {
           errores.add("El email es requerido");
            //por ahora deje que el navegador validara si el formato de un email es correcto
            //con el input type="email", pero después se verá como hacer, la revisión más fuerte con expresiones regulares
        }
        if(pais== null || pais.isBlank())
        {
            errores.add("El país es requerido");
        }
        if(lenguajes== null || lenguajes.length== 0)
        {
            errores.add("Tienes que seleccionar por lo menos un lenguaje");
        }
        if(roles== null || roles.length== 0)
        {
            errores.add("Tienes que elegir por lo menos un rol");
        }
        if(idioma== null)
        {
            errores.add("Se tiene que seleccionar un idioma");
        }
        //no se valida habilitar porque solo puede tener dos valores on o null, y los dos valores los usamos, es decir
        //  no hay problema
        //tampoco se valido el campo oculto, pues el usuario non interactua con el.
        
        try (PrintWriter out = res.getWriter()) 
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("   <head>");
            out.println("   <title>Resultado del form</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("   <h1>Datos ingresados (para validar)</h1>");
            out.println("       <ul>");
            
            ///si los erroees estan vacios se muestran los valores
            if (errores.isEmpty()) 
            {
                out.println("           <li>Username: " + username + "</li>");
                out.println("           <li>Password: " + password + "</li>");
                out.println("           <li>Email: " + email + "</li>");
                out.println("           <li>País: " + pais + "</li>");

                out.println("           <li>Lenguajes:");
                out.println("               <ul>");
                Arrays.asList(lenguajes).forEach(lenguaje -> {
                    out.println("               <li>" + lenguaje + "</li>");
                });
                out.println("                   <ll>");
                out.println("               </ul>");
                out.println("           </li>");

                out.println("           <li>Roles:");
                out.println("               <ul>");
                Arrays.asList(roles).forEach(rol -> {
                    out.println("               <li>" + rol + "</li>");
                });
                out.println("                   <ll>");
                out.println("               </ul>");
                out.println("           </li>");

                out.println("           <li>Idioma seleccionado: " + idioma + "</li>");
                out.println("           <li>Habilitada o deshabiitada: " + habilitar + "</li>");
                out.println("           <li>Valor de campo ocuto: " + secreto + "</li>");

            }
            else // si hay errores se muestran los errores
            {
                errores.forEach(error -> {
                    out.println("<li>" + error + "</li>");
                });
                out.println("<p><a href=\"/05_Jakarta_02_webapp-form/index.html\">Regresar al inicio</a></p> ");
            }
            
            out.println("       </ul>");
            
            
            out.println("   </body>");
            out.println("</html>");
        }
    }

}
