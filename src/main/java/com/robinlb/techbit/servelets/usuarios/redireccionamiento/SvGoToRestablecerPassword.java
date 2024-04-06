package com.robinlb.techbit.servelets.usuarios.redireccionamiento;

import com.robinlb.techbit.controllers.LogicController;
import com.robinlb.techbit.model.Usuario;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Robin
 */
@WebServlet(name = "SvGoToRestablecerPassword", urlPatterns = {"/SvGoToRestablecerPassword"})
public class SvGoToRestablecerPassword extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
  }

  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
    
    LogicController control = new LogicController();
    
    String stringID = (String) request.getParameter("idForResetPassword");
    Long userID = Long.parseLong(stringID);
    
    try {
      Usuario user = control.verUsuario(userID);
      
      HttpSession passReset = request.getSession(false);
      passReset.setAttribute("UserPassReset", user);
      
      response.sendRedirect("RestablecerPasswordUsuario.jsp");
      
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
      response.sendRedirect("PageError500.jsp");
    }
    
  }

}
