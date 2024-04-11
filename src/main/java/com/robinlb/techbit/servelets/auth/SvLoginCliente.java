package com.robinlb.techbit.servelets.auth;

import com.robinlb.techbit.controllers.LogicController;
import com.robinlb.techbit.controllers.PasswordSecurityService;
import com.robinlb.techbit.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servelet de inicio de sesión del cliente natural.
 *
 * @author Robin
 */
@WebServlet(name = "SvLoginCliente", urlPatterns = {"/SvLoginCliente"})
public class SvLoginCliente extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
  }

  /**
   * 
   * 
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException 
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);

    LogicController control = new LogicController();
    PasswordSecurityService secure = new PasswordSecurityService();
    Usuario usuario = null;

    String username = (String) request.getParameter("nombre_usuario");
    String password = (String) request.getParameter("contraseña");

    try {
      usuario = control.buscarUsuarioClienteNaturalPorUsername(username);
      boolean matchPassword = secure.matches(password, usuario.getContraseña());
      
      if (matchPassword) {
        HttpSession userC = request.getSession();
        userC.setAttribute("usuario-cliente", usuario);
        
        response.sendRedirect("Dashboard-Cliente.jsp");
        
      } else {
        response.sendRedirect("LoginCliente.jsp?password=false");
      }

    }
    catch (Exception e) {
      System.out.println(e.getMessage());
      response.sendRedirect("LoginCliente.jsp?user=false");
    }

  }

  // </editor-fold>
}
