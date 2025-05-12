/**
 * En este caso se va a usar el método doGet para obtener los datos del formulario
 *  (se podría recibir datos con doGet, es deecir no es obligatorio usar uno u oto)
 *  En el caso de doGet los datos no se ven en la url, esto es bueno si se quieren 
 *      usar datos privador como una contraseña
 * 
 *  NOTA: en el caso de querer recibir datos con doGet, se tiene que hacer
 *      Agregar el método doGet (o se podría camiar doPost por doGet
 *      En el index hay que cambiar el método de form action a get o quitar esa etiqueta
 *          por default se madan por doGet
 */
package apiservlet.webapp.form;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//esta linea la genero atuomáticamente, hasta ahora solo ponia @WebServlet("/registro")
@WebServlet(name = "FormServlet", urlPatterns = {"/registro"})
public class FormServlet extends HttpServlet 
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
        
        try (PrintWriter out = res.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("   <head>");
            out.println("   <title>Resultado del form</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("   <h1>Datos ingresados</h1>");
            out.println("       <ul>");
            out.println("           <li>Username: " + username + "</li>");
            out.println("           <li>Password: " + password + "</li>");
            out.println("           <li>Email: " + email + "</li>");
            out.println("           <li>País: " + pais + "</li>");
            
            out.println("           <li>Lenguajes:");
            out.println("               <ul>");
            Arrays.asList(lenguajes).forEach(lenguaje -> {out.println("               <li>" + lenguaje + "</li>");});
            out.println("                   <ll>");
            out.println("               </ul>");
            out.println("           </li>");
            
            out.println("           <li>Roles:");
            out.println("               <ul>");
            Arrays.asList(roles).forEach(rol -> {out.println("               <li>" + rol + "</li>");});
            out.println("                   <ll>");
            out.println("               </ul>");
            out.println("           </li>");
            
            out.println("           <li>Idioma seleccionado: " + idioma + "</li>");
            out.println("           <li>Habilitada o deshabiitada: " + habilitar + "</li>");
            out.println("           <li>Valor de campo ocuto: " + secreto + "</li>");
            
            
            out.println("       </ul>");
            out.println("   </body>");
            out.println("</html>");
        }
    }

}
