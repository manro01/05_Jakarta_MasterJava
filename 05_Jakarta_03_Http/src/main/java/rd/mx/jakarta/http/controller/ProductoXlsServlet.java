/**
 * En este servlet vamos a usar un arreglo de rutas para el servlet, hasta ahora
 *  vimos como poner una sola ruta al servlet, en esteejemplo vamos a usar dos 
 *  para esto las rutas se ponen en un arreglos (se ponen dentro de los {} y 
 *  se separan por comas).
 * 
 * Cuando hay dos rutas hay que poner un proceso para saber cual se esta usando, en 
 *  caso se creo el booleano esXls para saber si la ruta termina con .xls 
 *  y dentro de la pagina, hay cosas que se van a hacer si la bandera es positiva
 *  o negativa
 * 
 * 
 */
package rd.mx.jakarta.http.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import rd.mx.jakarta.http.models.Producto;
import rd.mx.jakarta.http.services.ProductoService;
import rd.mx.jakarta.http.services.ProductoServiceImpl;

@WebServlet(name = "ProductoXlsServlet", urlPatterns = {"/productos.xls", "/productos.html"})
public class ProductoXlsServlet extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        ProductoService service= new ProductoServiceImpl();
        List<Producto> productos= service.listar();
        
        resp.setContentType("text/html;charset=UTF-8");
        String servletPath= req.getServletPath(); //obtener la ruta que estamos usando, en este caso pueden ser dos
        boolean esXls= servletPath.endsWith(".xls"); //bandera para saber si estamos en .xls o no
        
        if(esXls)
        {
            resp.setContentType("application/vnd.ms-excel"); //esto es para exportarlo a excel
            resp.setHeader("Content-Disposition", "attachment.filename=productos.xls"); 
                //estos es para inciar la descargar automaticamente cuando se carge la página, NO VA A LA página, inicia la descarga
        }
        
        try (PrintWriter out = resp.getWriter()) 
        {
            if(!esXls) //si no es la ruta de .xls esto no se muestra
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("   <head>");
                out.println("   <title> Listado de productos </title>");
                out.println("</head>");
                out.println("<body>");
                out.println("   <h1> Listados de productos </h1>");
                out.println("<p><a href=\""+ req.getContextPath() + "/productos.xls" + "\">exportar a xls</a></p>");
                out.println("<p><a href=\""+ req.getContextPath() + "/productos.json" + "\">mostrar a json</a></p>");
            }
            
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Id</th>");
            out.println("<th>Nombre</th>");
            out.println("<th>Tipo</th>");
            out.println("<th>Precio</th>");
            out.println("</tr>");
            productos.forEach(p->{
                out.println("<tr>");
                out.println("<td>" + p.getId() + "</td>");
                out.println("<td>" + p.getNombre()+ "</td>");
                out.println("<td>" + p.getTipo()+ "</td>");
                out.println("<td>" + p.getPrecio()+ "</td>");
                out.println("</tr>");
            });
            out.println("</table>");
            
            if(!esXls)//si no es la ruta de .xls esto no se muestra
            {
                out.println("</body>");
                out.println("</html>");
            }
        }
    }
}
