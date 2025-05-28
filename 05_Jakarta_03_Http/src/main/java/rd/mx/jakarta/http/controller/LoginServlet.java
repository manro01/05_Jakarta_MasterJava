/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rd.mx.jakarta.http.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
    final static String USERNAME= "admin";
    final static String PASSWORD= "12345";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String username= req.getParameter("username");
        String password= req.getParameter("password");
        
        if(USERNAME.equals(username) && PASSWORD.equals(password))
        {
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("   <head>");
                out.println("   <title> Login</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("   <h1> Login </h1>");
                out.println("<h3>Hola usuario " + username + " has iniciado sesión con exito </h3>");
                out.println("</body>");
                out.println("</html>");
            }
        }
        else
        {
            //resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No estas autorizado para ingresar");
            //las dos lineas hacen el trabajo de regresar un código de no autorización pero la segunda forma nos permite agregar un mensaje
        }
    }
    
}
