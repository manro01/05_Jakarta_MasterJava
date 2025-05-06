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
 * NOTA: tal como quedo el ejercicio este ya no se uso
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
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println(" <head>");
        out.println("     <Title>Hola desde Servlet</Title>");
        out.println("     <meta charset=\"UTF-8\">  ");
        out.println(" </head>");
        out.println(" <body>");
        out.println("     <h1>Holas que vienen y van en servlet</h1>");
        out.println(" </body>");
        out.println("</html>");
        out.close(); //est lo agregue sin probar
        //si no cerramos el recurso no hay problema se cierra solo, pero por buena prácica se cierra
        
    }
            
}
