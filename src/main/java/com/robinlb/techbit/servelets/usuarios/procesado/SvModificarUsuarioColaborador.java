package com.robinlb.techbit.servelets.usuarios.procesado;

import com.robinlb.techbit.controllers.LogicController;
import com.robinlb.techbit.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.awt.desktop.UserSessionEvent;

/**
 *
 * @author Robin
 */
@WebServlet(name = "SvModificarUsuarioColaborador", urlPatterns = {"/SvModificarUsuarioColaborador"})
public class SvModificarUsuarioColaborador extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
  }

  /**
   * Handles the HTTP <code>POST</code> method.
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
    
    Usuario user = (Usuario) request.getSession(false).getAttribute("usuarioModificar");
    
    String username = (String) request.getParameter("validationServerUsername");
    String privilegios = (String) request.getParameter("validationServerAccess");
    
    user.setNombreUsuario(username);
    user.setPrivilegios(privilegios);
    
    try {
      control.actualizarUsuario(user);
      
      HttpSession userMod = request.getSession(false);
      userMod.removeAttribute("usuarioModificar");
      
      response.sendRedirect("SvGoToUsuariosColaboradores");
      
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
      
      HttpSession userMod = request.getSession(false);
      userMod.removeAttribute("usuarioModificar");
      
      response.sendRedirect("PageError500.jsp");
    }
    
  }

}
