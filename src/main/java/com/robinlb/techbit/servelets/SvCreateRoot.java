package com.robinlb.techbit.servelets;

import com.robinlb.techbit.controllers.LogicController;
import com.robinlb.techbit.controllers.PasswordSecurityService;
import com.robinlb.techbit.model.Usuario;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Registra un usuario root para el primer inicio de sesión de la aplicación 
 */
@WebServlet(name = "SvCreateRoot", urlPatterns = {"/SvCreateRoot"})
public class SvCreateRoot extends HttpServlet {
    
    PasswordSecurityService passwordSecure = new PasswordSecurityService();
    LogicController control = new LogicController();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String password = (String) request.getParameter("contraseña");
        String encryptedPassword = passwordSecure.encrypt(password);
        
        try {
            Usuario usuario = new Usuario();
            usuario.setNombreUsuario("root");
            usuario.setContraseña(encryptedPassword);
            usuario.setPrivilegios("admin");
            
            control.crearUsuario(usuario);
            
            response.sendRedirect("page-login.jsp");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
