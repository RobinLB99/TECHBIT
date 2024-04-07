package com.robinlb.techbit.servelets.usuarios.procesado;

import com.robinlb.techbit.controllers.LogicController;
import com.robinlb.techbit.controllers.PasswordSecurityService;
import com.robinlb.techbit.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Robin
 */
@WebServlet(name = "SvRestablecerContraseña", urlPatterns = {"/SvRestablecerContrase_a"})
public class SvRestablecerContraseña extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
  }

  /**
   * Metodo <code>POST</code> que restablece la contraseña del usuario
   * del colaborador seleccionado.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
    
    LogicController control = new LogicController();
    PasswordSecurityService secure = new PasswordSecurityService();
    
    Usuario user = (Usuario) request.getSession(false).getAttribute("UserPassReset");
    String newPassword = request.getParameter("validationServerPassword");
    
    String securePassword = secure.encrypt(newPassword);
    
    user.setContraseña(securePassword);
    
    HttpSession session = request.getSession(false);
    
    try {
      control.actualizarUsuario(user);
      
      session.removeAttribute("UserPassReset");
      session.setAttribute("is-password-reseted", true);
      
      response.sendRedirect("SvGoToUsuariosColaboradores");
    }
    catch (Exception e) {
      session.setAttribute("is-password-reseted", false);
      response.sendRedirect("SvGoToUsuariosColaboradores");
    }
    
  }

}
