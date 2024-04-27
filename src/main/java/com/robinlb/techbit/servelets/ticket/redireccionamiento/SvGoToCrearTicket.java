package com.robinlb.techbit.servelets.ticket.redireccionamiento;

import com.robinlb.techbit.controllers.JSONController;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.json.JSONArray;

/**
 *
 * @author Robin
 */
@WebServlet(name = "SvGoToCrearTicket", urlPatterns = {"/SvGoToCrearTicket"})
public class SvGoToCrearTicket extends HttpServlet {

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
    
    JSONController jcontrol = new JSONController();
    JSONArray categorias = jcontrol.obtenerJSONArray("/tickets/category_tickets.json");
    
    HttpSession session = request.getSession(false);
    session.setAttribute("categorias", categorias);
    
    response.sendRedirect("CrearTicket.jsp");
    
  }// </editor-fold>

}
