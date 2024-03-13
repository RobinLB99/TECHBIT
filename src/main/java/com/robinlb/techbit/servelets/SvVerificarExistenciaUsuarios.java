package com.robinlb.techbit.servelets;

import com.robinlb.techbit.controllers.LogicController;
import com.robinlb.techbit.model.Usuario;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 *  Verifica si existe algún usuario registrado.
 *  Si existe uno o mas usuarios registrados, redirige a la pagina de login.
 *  Si no existe ningun usuario, redirige a la pagina de registro de usuario root.
 *  Se ejecuta al iniciar la aplicación.
 */
@WebServlet(name = "SvVerificarExistenciaUsuarios", urlPatterns = {"/SvVerificarExistenciaUsuarios"})
public class SvVerificarExistenciaUsuarios extends HttpServlet {
    
    LogicController control = new LogicController();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Collection<Usuario> usuarios = control.listaUsuarios();
        
        if (usuarios.isEmpty()) {
            response.sendRedirect("RegisterRoot.jsp");
        } else response.sendRedirect("Login.jsp");
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
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
