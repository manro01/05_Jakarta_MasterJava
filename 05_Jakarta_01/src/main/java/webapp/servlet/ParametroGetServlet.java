/**
 * Aquí se va a mostrar como pasar datos a un servlet
 * Para este ejemplo los parámetros se van a recibir por la url 
 *  Donde se quiera usar el servlet se tienen que mandar el o los valores en la url del servlet seguido de ?, 
 *      seguido del par clave=valor, por ejemplo, en el index se quiere usar este servlet, entonces se usa
 *              href="/parametros/url-get?primerNombre=Pepe"
 *      En caso de requerir más de un párametro se separan por &
 *              href="/parametros/url-get?primerNombre=Pepe&segundoNombre=Magaña"
 *  Para obtener los valores se usa un objeto de HttpServletRequest normalmente, este objeto se declara en la
 *      definición del doGet, y el método para usarlo es objetoDe(HttpServletRequest).getParameter("parametro");  por ejemplo, 
 *                  req.getParameter("primerNombre");
 * NOTA: los valores que regresa getParameter son String, por lo que, si queremos usar otro tipo de
 *      valor hay que castearlo
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
        
        String nombre= req.getParameter("nombre"); //// guardamos el valor de la variable usuario

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println(" <head>");
        out.println("     <Title>Hola desde Servlet para recibir datos</Title>");
        out.println("     <meta charset=\"UTF-8\">  ");
        out.println(" </head>");
        out.println(" <body>");
        out.println("     <h1>Los datos que se recibieron son</h1>");
        
        //Como se usa un Integer, se tiene que hacer la conversión, pero en la conversión se tiene que poner el try
        // el mismo try, nos va a servir como if, 
        //  entonces, si la conversón es valida
        //          se revisa si hay nombre 
        //              con el nombre: se muestra solo el nombre
        //              sin el nombre: se muestra solo el id
        //  en caso de que la conversión falle
        //          se revisa si hay nombre 
        //              con el nombre: se muestra solo el nombre
        //              si el nombre: se muestra mensaje de que no hay valores
        //Nota: parece que se revisa el nombre 2 veces pero no es así, solo se revisa una vez
        //  es decir si no hay falla en la conversión se hace una revisión de nombre y
        //  si hay falla en la conversión se hace una revisión del nombre
        try 
        {
        Integer id=Integer.valueOf(req.getParameter("id"));
            if(nombre!= null)
        {
            out.println("       <param>El usuario enviado es: " + nombre + " con el id " + id + "</param>");
        }
            else //no se recibio nombre pero si id
        {
            out.println("       <param>El id del usuario es: " + id + "</param>");
        }
        } catch (NumberFormatException e) {
            if(nombre!=null) //si se recibio nombre pero no id
            {
                out.println("       <param>El usuario ingresado es: " + nombre +  "</param>");
            }
            else //no se recibieron ni nombre ni id
            {
                out.println("       <param>No se recibieron valores  </param>");
            }
        }

        out.println(" </body>");
        out.println("</html>");
        out.close(); //est lo agregue sin probar
        //si no cerramos el recurso no hay problema se cierra solo, pero por buena prácica se cierra
    }
    
}
