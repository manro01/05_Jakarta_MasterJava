/*
 */
package rd.mx.jakarta.http.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Optional;
import rd.mx.jakarta.http.models.Producto;
import rd.mx.jakarta.http.services.ProductoService;
import rd.mx.jakarta.http.services.ProductoServiceImpl;

@WebServlet(name = "BuscarProductoServlet", urlPatterns = {"/buscar-producto"})
public class BuscarProductoServlet extends HttpServlet 
{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        ProductoService service= new ProductoServiceImpl();
        String nombre= req.getParameter("producto");

        Optional<Producto> encontrado= service.buscarProducto(nombre);
        
        if(encontrado.isPresent())
        {
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("   <head>");
                out.println("   <title>Producto encontrado</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("   <h1> La suqueda de la palabra: [ " + nombre + " ] tiene como resulado:</h1>");
                out.println("<h3>" + encontrado.get().getNombre() + " Id: " + encontrado.get().getId() + " Precio $ " + encontrado.get().getPrecio() + "</h3>");
                out.println("</body>");
                out.println("</html>");
            }
        }
        else
        {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No existe el producto " + nombre);
        }
    }

    

}
