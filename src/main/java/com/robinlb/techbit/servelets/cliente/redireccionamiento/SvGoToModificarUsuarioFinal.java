package com.robinlb.techbit.servelets.cliente.redireccionamiento;

import com.robinlb.techbit.controllers.LogicController;
import com.robinlb.techbit.model.ClienteNatural;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author joel
 */
@WebServlet(name = "SvGoToModificarUsuarioFinal", urlPatterns = {"/SvGoToModificarUsuarioFinal"})
public class SvGoToModificarUsuarioFinal extends HttpServlet {

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
    
    Long id = Long.parseLong( (String) request.getParameter("inIDUserMod") );
    
    try {
      ClienteNatural usuarioFinal = control.buscarClienteNatural(id);
      
      HttpSession e = request.getSession(false);
      e.setAttribute("usuarioModificar", usuarioFinal);
      
      response.sendRedirect("ActualizarUsuarioFinal.jsp");
      
    } catch (Exception e) {
      response.sendRedirect("PageError500.jsp");
    }
    
  }// </editor-fold>

}
