/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package rd.mx.jakarta.http.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import rd.mx.jakarta.http.models.Producto;
import rd.mx.jakarta.http.services.ProductoService;
import rd.mx.jakarta.http.services.ProductoServiceImpl;

@WebServlet(name = "ProductoJasonServlet", urlPatterns = {"/productos.json"})
public class ProductoJasonServlet extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        ProductoService service= new ProductoServiceImpl();
        List<Producto> productos= service.listar();
        
        ObjectMapper mapper= new ObjectMapper(); //ObjectMapper es de com.fasterxml.jackson.databind
        String json= mapper.writeValueAsString(productos);
        resp.setContentType("application/jason");
        resp.getWriter().write(json);
    }

}
