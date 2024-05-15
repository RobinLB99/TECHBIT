package com.robinlb.techbit.servelets.ticket.redireccionamiento;

import com.robinlb.techbit.controllers.LogicController;
import com.robinlb.techbit.model.TicketSoporte;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author joel
 */
@WebServlet(name = "SvGoToNoAsigmentTickets", urlPatterns = {"/SvGoToNoAsigmentTickets"})
public class SvGoToNoAsigmentTickets extends HttpServlet {

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
    
    try {
      List<TicketSoporte> ticketsNoAignados = control.buscarTicketsNoAsignados();
      
      HttpSession a = request.getSession(false);
      a.setAttribute("TicketsNoAsignados", ticketsNoAignados);
      
      response.sendRedirect("TicketsNoAsignados.jsp");
      
    } catch (Exception e) {
      response.sendRedirect("PageError500.jsp");
    }
    
    
  }// </editor-fold>

}
