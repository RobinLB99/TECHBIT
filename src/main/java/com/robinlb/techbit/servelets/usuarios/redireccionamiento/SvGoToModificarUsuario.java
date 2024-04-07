package com.robinlb.techbit.servelets.usuarios.redireccionamiento;

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

/**
 *
 * @author Robin
 */
@WebServlet(name = "SvGoToModificarUsuario", urlPatterns = {"/SvGoToModificarUsuario"})
public class SvGoToModificarUsuario extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
    
    String stringID = (String) request.getParameter("inIdEmMod");
    Long userUD = Long.parseLong(stringID);
    
    try {
      Usuario user = control.verUsuario(userUD);
      
      HttpSession us = request.getSession(false);
      us.setAttribute("usuarioModificar", user);
      
      response.sendRedirect("ModificarUsuarioColaborador.jsp");
      
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
      response.sendRedirect("PageError500.jsp");
    }
    
  }
// </editor-fold>

}
