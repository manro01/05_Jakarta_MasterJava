/**
 * Se va ejemplificar como refrescar una página cada cierto tiempo de manera automática
 *  Basta con usar resp.setHeader("refresh", "1");, donde refresh es la acción a realizar 
 *      y 1 es el tiempo que se tarda en realiarla
 * NOTA MUY MUY IMPORTANTE: En este caso se recarga todo el jsp (que es la página) lo 
 *  que conlleva una carga de recursos, bastante grande por lo que hay que tener cuidad para usarla
 */
package rd.mx.jakarta.http.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "HoraActualizadaServlet", urlPatterns = {"/hora-actualizada"})
public class HoraActualizadaServlet extends HttpServlet 
{

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param req
     * @param resp
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        resp.setContentType("text/html;charset=UTF-8");
        
        resp.setHeader("refresh", "1"); //esta es la parte que indica que hay que estar refrescando la página cada segundo
        
        LocalTime hora= LocalTime.now(); //creamos un objeto hora para mostrar
        DateTimeFormatter df= DateTimeFormatter.ofPattern("hh:mm:ss");
        
        try (PrintWriter out = resp.getWriter()) 
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("   <head>");
            out.println("   <title> Actualizar hora </title>");
            out.println("</head>");
            out.println("<body>");
            out.println("   <h1>La hora exacta es</h1>");
            out.println("<h3>" + hora.format(df) + "</h3>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param req
     * @param resp
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
    }


}
