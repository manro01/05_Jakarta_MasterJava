/**
 * Aquí se va a mostrar como pasar datos a un servlet
 */
package webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/parametros/url-get")
public class ParametroGetServlet extends HttpServlet
{

    /**
     * En este caso se va a recibie un argumento por doGet.
     * doGet recibe los datos por medio de la url, para que funcione se debe poner
     * la url de este servlet seguido de ? seguido del nombre del argumento seguido del valor
     * /parametros/url-get?usuario=pepe
     * Ya en el doGet se tiene que configurar una variable que reciba el valor y lo guarde
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html");
        PrintWriter out= resp.getWriter();
        
        String saludo= req.getParameter("usuario"); //// guardamos el valor de la variable usuario
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println(" <head>");
        out.println("     <Title>Hola desde Servlet para recibir datos</Title>");
        out.println("     <meta charset=\"UTF-8\">  ");
        out.println(" </head>");
        out.println(" <body>");
        out.println("     <h1>Los datos que se recibieron son</h1>");
        out.println("       <param>El usuario enviado es: " + saludo + "</param>");
        out.println(" </body>");
        out.println("</html>");
        out.close(); //est lo agregue sin probar
        //si no cerramos el recurso no hay problema se cierra solo, pero por buena prácica se cierra
    }
    
}
