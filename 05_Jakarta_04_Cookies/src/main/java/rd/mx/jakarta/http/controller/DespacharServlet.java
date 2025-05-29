/**
 * Unir un request a otro request, esto si se tiene que hacer entre recursos del mismo proyecto
 *  aquí no se va a hace un request nuevo si no que lo une a uno ya existente, por lo tanto
 *  mantiene datos como formulario
 */
package rd.mx.jakarta.http.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DespacharServlet", urlPatterns = {"/despachar"})
public class DespacharServlet extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        request.getServletContext().getRequestDispatcher("/productos.html").forward(request, response);
    }
}
