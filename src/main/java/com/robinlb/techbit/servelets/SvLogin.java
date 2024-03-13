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
 *  Servicio de inicio de sesión
 */
@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {

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

        String username = (String) request.getParameter("nombre_usuario");
        String password = (String) request.getParameter("contraseña");

        try {
            Usuario usuario = control.verUsuarioPorNombreUsuario(username);
            PasswordSecurityService passwordSecure = new PasswordSecurityService();
            boolean match = passwordSecure.matches(password, usuario.getContraseña());

            if (match) {
                usuario.setSesionActiva(true);
                control.actualizarUsuario(usuario);
                
                response.sendRedirect("dashboard.jsp");
                
            } else {
                response.sendRedirect("page-login.jsp?password=incorrect");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            response.sendRedirect("page-login.jsp?user=false");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
