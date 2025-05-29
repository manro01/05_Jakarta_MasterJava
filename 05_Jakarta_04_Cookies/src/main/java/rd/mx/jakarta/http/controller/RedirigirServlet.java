/**
 * Vamos a redirigir a una página.
 * El redireccionamiento puede ser a la misma página, a otar página del mismo proyecto
 *  o a otra pagina fuera del proyecto,
 * Como lo vamos a hacer aquí, cada que se redirecciona es como se cargara desde
 *  cero la página, es decir si hay algun recurso guardado lo borra.
 * 
 */
package rd.mx.jakarta.http.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "RedirigirServlet", urlPatterns = {"/redirigir"})
public class RedirigirServlet extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException 
    {
        //resp.setHeader("Location", req.getContextPath()+"/productos.html");
        //resp.setStatus(HttpServletResponse.SC_FOUND); //con esto indicamos que se encontro el recurso al que se va a ir
        
        //NOTA las dos lineas de arriba se pueden se pueden reemplazar por
        
        resp.sendRedirect(req.getContextPath()+"/productos.html");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    }

}
