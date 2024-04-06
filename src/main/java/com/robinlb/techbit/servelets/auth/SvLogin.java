package com.robinlb.techbit.servelets.auth;

import com.robinlb.techbit.controllers.LogicController;
import com.robinlb.techbit.controllers.PasswordSecurityService;
import com.robinlb.techbit.model.Usuario;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servicio de inicio de sesión
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
    
    PasswordSecurityService passwordSecure = new PasswordSecurityService();

    String username = (String) request.getParameter("nombre_usuario");
    String password = (String) request.getParameter("contraseña");

    try {
      Usuario usuario = control.verUsuarioPorNombreUsuario(username);
      boolean match = passwordSecure.matches(password, usuario.getContraseña());

      if (match) {
        HttpSession session = request.getSession();
        session.setAttribute("user", usuario);

        response.sendRedirect("Dashboard.jsp");

      } else {
        response.sendRedirect("Login.jsp?password=incorrect");
      }

    }
    catch (Exception e) {
      System.out.println(e.getMessage());
      response.sendRedirect("Login.jsp?user=false");
    }

  }

  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
