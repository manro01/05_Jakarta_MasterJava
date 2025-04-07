/**
 * Probando un servlet sencillo
 * 
 * Para usar un servlet hay que routearlo, asociarle una ruta, esta ruta debe
 *  Estar entre " " por se un string
 *  Empezar con un /
 *  Puede ser cualquier nombre 
 *  No puede tener caracteres especiales  como @ o # 
 * 
 * La clase debe heredar de HttpServlet
 * La clase debe tener métodos para manejar los resonse
 * 
 * 
 */
package webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hola-mundo")      //con esto asociamos una ruta al servlet
public class HolaMundoServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        
        out.print("<!Doctype html>");
        out.print("<html>");
        out.print(" <body>");
        out.print("     <head>");
        out.print("         <meta charset=\"\"UTF-8 >");
        out.print("         <Title>Hola mundo Servlet</Title>");
        out.print("     </head>");
        out.print("     <body>");
        out.print("         <HOlas que vienen y van en servlet>");
        out.print("     </body>");
        out.print(" </body>");
        out.print("</html>");
    }
            
}
