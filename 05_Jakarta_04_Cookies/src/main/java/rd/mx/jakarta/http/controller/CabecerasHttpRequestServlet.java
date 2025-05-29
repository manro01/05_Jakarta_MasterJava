/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package rd.mx.jakarta.http.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@WebServlet(name = "CabecerasHttpRequestServlet", urlPatterns = {"/cabeceras-request"})
public class CabecerasHttpRequestServlet extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        resp.setContentType("text/html;charset=UTF-8");
        
        String metodoHttp= req.getMethod(); //regresa el método usada para la página, get, post, put etc
        String requestUri= req.getRequestURI(); //regresa el url pero solo lo que va después del port8080, es decir el "directorio del proyecto"
        String requestUrl= req.getRequestURL().toString(); //regresa toda la url del proyecto desde el http:// etc
            //getRequestURL() regresa un StrinBuffer por o que hay que convertirlo a String
        String contexthPath= req.getContextPath(); //regresa el contexto del proyexto, el nombre del proyecto
        String servletPath= req.getServletPath(); //regresa la dirección del servlet
        String ip= req.getLocalAddr();//regresa la ip del servidor que tiene el ryoecto en este cao TOMCAT
        int port= req.getLocalPort(); //regresa el puero que usa el proyecto
        String schem= req.getScheme();
        String host= req.getHeader("host");
        
        //Obteniendo los datos indivicuales del url
        String urlConHost= schem + "://" + host + contexthPath + servletPath;
        String urlConIp= schem + "://" + ip + ":" + port + contexthPath + servletPath;
        
        //informacion del cliente
        String ipCliente= req.getRemoteAddr();
        int portCliente= req.getServerPort();
        
        try (PrintWriter out =resp.getWriter())
        {
            out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("   <head>");
                out.println("   <title>Cabeceros Http</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("   <h1>Cabeceros Http</h1>");
                out.println("<ul> información local, es la información de la pc que ejecuta el proyecto");
                out.println("   <li>método http: " + metodoHttp + "</li>");
                out.println("   <li>request uri: " + requestUri + "</li>");
                out.println("   <li>request url: " + requestUrl + "</li>");
                out.println("   <li>contexth path: " + contexthPath + "</li>");
                out.println("   <li>servleet path: " + servletPath + "</li>");
                out.println("   <li>ip local: " + ip + " puede estar en formato ip4 o ip6 dependiendo del navegador</li>");
                out.println("   <li>puerto: " + port + "</li>");
                out.println("   <li>scheme: " + schem + "</li>");
                out.println("   <li>url con host: " + urlConHost + "</li>");
                out.println("   <li>url cn ip: " + urlConIp + "</li>");
                out.println("</ul>");
                out.println("<ul> Información del cliente, esta es la infomación de la compu que esta accediedo al proyecto");
                out.println("   <li>url cn ip: " + ipCliente + "</li>");
                out.println("   <li>url cn ip: " + portCliente + "</li>");
                out.println("</ul>");
                
                Enumeration<String> headerNames= req.getHeaderNames();
                out.println("<ul> todo los cabeceros");
                while(headerNames.hasMoreElements())
                {
                    String cabecera= headerNames.nextElement();
                    out.println("<li>"+ cabecera + ": " + req.getHeader(cabecera) + "</li>");
                }
                out.println("</ul>");
                out.println("</body>");
                out.println("</html>");
                
        }
    }

}
