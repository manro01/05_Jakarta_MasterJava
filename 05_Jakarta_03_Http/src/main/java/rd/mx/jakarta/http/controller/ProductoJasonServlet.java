/**
 * En este caso se va a mostar como usar un objeto Json, pero se va a incluir dos ejemplos, 
 * como recibirlo desde la misma apliación y como recibirlo externamente desde un servidor
 * http, en este caso postman.
 * 
 * Desde la misma aplicación
 *  En este caso se tiene que hacer una clase que despache el objeto, aquí se uso un objeto de 
 *      ProductoServiceImpl.java que llamamos service [ProductoService service= new ProductoServiceImpl();]
 *          service ya devuelve una lista de objetos de tipo Producto.
 *  Con String json= mapper.writeValueAsString(productos); transformamos la lista a un arreglo json.
 *  Con resp.setContentType("application/json"); indicamos el tipo de contenido que es, en este caso un json, 
 *      En este punto indicamos que se requiere una aplicación que abra el archivo json y si el navegador
 *          la incluye se abre en el mismo navegador de lo contrario manda a descargar el archivo.
 *  Con resp.getWriter().write(json); la escribimos en la página a mostrar o en el archivo de descarga.
 * 
 * Externo a la apliación
 *  En este caso se manda el objeto json desde un método externo por ejemplo una apliación http
 *      en este caso usaremos Postman, 
 *  Desde Postman se crea el objeto json y se manda y ahí mismo se ve la respuesta.
 * 
 * Postman 
 *  Una vez abierto se elige el tipo de acción, puede ser get, post etc.
 *  Tal como hicimos el programa se puede hacer una petición get con http://localhost:8080/05_Jakarta_03_Http/productos.json
 *      esto muestra la lista de Productos que se crearon con el objeto service.
 *  Se puede hacer también una petición post
 *      Se selecciona la acción post, se escribe la dirección http://localhost:8080/05_Jakarta_03_Http/productos.json
 *          pero en BODY se le llena con el cuerpo de un objeto json
 *              {"id": 3, "nombre": "mouse", "tipo": "computacion", "precio": 20000} puede ser así o con
 *          enters entre cada valor, en caso de ser una lista de objeto se encierra entre [] y cada objeto 
 *          se coloca entre{} y se separan por comas
 *              [{"id": 1, "nombre": "notebook", "tipo": "computacion", "precio": 175000},{"id": 2,"nombre": "mesa escritorio","tipo": "oficina","precio": 100000}]
 *  Se le da en enviar y si todo sale bien se obtiene el resultado deseado, la respuesta se va a recibir y se 
 *      muestra sin formato, pero para verla con el formato se pone en Preview.
 *      Con formato quiero decir la estructura de un objeto html.
 * 
 */
package rd.mx.jakarta.http.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
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
        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }

    /**
     * vamos a hacer que se reciba un json.
     * Lo vamos a recibir como un flujo
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        ServletInputStream jsonStream= req.getInputStream(); //obtnemos el json que viene de la petición html y lo recibimos como un flujo
        ObjectMapper mapper= new ObjectMapper(); //creamos este objeto para facilitar la conversión de json a Producto
        Producto produto= mapper.readValue(jsonStream, Producto.class); //efectuamos la conversión, con esto ya tenemos un objeto Producto que podemos usar
        
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("   <head>");
            out.println("   <title>Recuperando Json</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("   <h1> Json recuperado </h1>");
            out.println("<ul>");
            out.println("   <li> Id: " + produto.getId() + " </li>");
            out.println("   <li> Nombre: " + produto.getNombre() + " </li>");
            out.println("   <li> Tipo: " + produto.getTipo() + " </li>");
            out.println("   <li> Precio:" + produto.getPrecio() + " </li>");
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    

}
