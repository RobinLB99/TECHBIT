package com.robinlb.techbit.servelets;

import com.robinlb.techbit.controllers.LogicController;
import com.robinlb.techbit.model.Usuario;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Collection;

/**
 * Se ejecuta al iniciar la aplicación y verifica si existe algún usuario registrado. 
 */
@WebServlet(name = "SvVerificarExistenciaUsuarios", urlPatterns = {"/SvVerificarExistenciaUsuarios"})
public class SvVerificarExistenciaUsuarios extends HttpServlet {

    LogicController control = new LogicController();

    /**
    * Si existe uno o mas usuarios registrados, redirige a la pagina de login.
    * Si no existe ningún usuario, redirige a la pagina de registro de usuario root.
    * Si iniciada una sesión, se establece la URI raiz, este servelet redirigira al Dashboard inmediatamente.
    * Si no existe una sesión activa y se establece la URI raiz, este servelet redirigira a la pagina Login.
    * 
    * @param request
    * @param response
    * @throws ServletException
    * @throws IOException 
    */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession requestSession = null;
        String log = (String) request.getSession().getAttribute("session");
        
        if (log == null) {
            log = "logoff";
            requestSession = request.getSession();
            requestSession.setAttribute("session", log);
        }

        Collection<Usuario> usuarios = control.listaUsuarios();

        if (usuarios.isEmpty()) {
            response.sendRedirect("RegisterRoot.jsp");
        } else if (log.equals("logon")) {
            response.sendRedirect("Dashboard.jsp");
        } else if (log.equals("logoff")) {
            response.sendRedirect("Login.jsp");
        }
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
