/**
 * Es lo mismo que el ejercicio anterior solo que se va usar Bootstrap para mejorar
 *  la vista.
 */
package apiservlet.webapp.form;

import jakarta.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Servlet05_ConBootstrap", urlPatterns = {"/conBootsrap"})
public class Servlet05_ConBootstrap extends HttpServlet 
{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {
        res.setContentType("text/html;charset=UTF-8");
        
        String username= req.getParameter("username");
        String password= req.getParameter("password");
        String email= req.getParameter("email");
        String pais= req.getParameter("pais");
        String[] lenguajes= req.getParameterValues("lenguajes");
        String[] roles= req.getParameterValues("roles");
        String idioma= req.getParameter("idioma");
        boolean habilitar= req.getParameter("habilitar")!=null && req.getParameter("habilitar").equals("on");
        //cuando no se checa la cajita de habilitado es null, por eso hay que comprobar primero si es null y luego 
        // hay que comprobar si es on porque creo que se puede cambiar el valor por default
        String secreto= req.getParameter("secreto");
        
        Map<String, String> errores= new HashMap<>();
        //se cambio list por Map
        
        if(username== null || username.isBlank())
        {
            errores.put("username","El username es requerido");
        }
        if(password== null || password.isBlank())
        {
            errores.put("password","El password no puede ser vacío");
        }
        if(email.isBlank())
        {
           errores.put("email","El email es requerido");
            //por ahora deje que el navegador validara si el formato de un email es correcto
            //con el input type="email", pero después se verá como hacer, la revisión más fuerte con expresiones regulares
        }
        if(pais== null || pais.isBlank())
        {
            errores.put("pais","El país es requerido");
        }
        if(lenguajes== null || lenguajes.length== 0)
        {
            errores.put("lenguajes","Tienes que seleccionar por lo menos un lenguaje");
        }
        if(roles== null || roles.length== 0)
        {
            errores.put("roles","Tienes que elegir por lo menos un rol");
        }
        if(idioma== null)
        {
            errores.put("idioma","Se tiene que seleccionar un idioma");
        }

        if (errores.isEmpty())
        {
            try (PrintWriter out = res.getWriter()) 
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("   <head>");
                out.println("   <title>Errores en el mismo form (Servlet_05)</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("   <h1>Los datos ingresados son: </h1>");
                out.println("       <ul>");
            
            
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
                out.println("           <li>Habilitada o deshabilitada: " + habilitar + "</li>"); //Este es un aviso de estado, no es un error
                out.println("           <li>Valor de campo ocuto: " + secreto + "</li>");

            
                out.println("       </ul>");
            
                out.print("<div>");
                out.println("   <p><a href=\"/05_Jakarta_02_webapp-form/05_ConBootstrap.jsp\">Regresar al formulario (05_ConBootstrap.jsp)</a></p> ");
                out.println("   <p><a href=\"/05_Jakarta_02_webapp-form/index.html\">Regresar al inicio</a></p> ");
                out.print("</div>");
            
            
                out.println("   </body>");
                out.println("</html>");
                
            }
        }
        else // si hay errores 
        {
            //se crea un atributo donde se van a guardar los errores
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/05_ConBootstrap.jsp").forward(req, res);
        }
    }
}
