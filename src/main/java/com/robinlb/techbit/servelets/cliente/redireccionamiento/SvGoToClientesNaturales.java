package com.robinlb.techbit.servelets.cliente.redireccionamiento;

import com.robinlb.techbit.controllers.LogicController;
import com.robinlb.techbit.model.ClienteNatural;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author Robin
 */
@WebServlet(name = "SvGoToClientesNaturales", urlPatterns = {"/SvGoToClientesNaturales"})
public class SvGoToClientesNaturales extends HttpServlet {

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

  }

  // <editor-fold defaultstate="collapsed">
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
      List<ClienteNatural> clientesNaturales = control.listaClientesNaturales();

      HttpSession clienteN = request.getSession(false);
      clienteN.setAttribute("clientes-naturales", clientesNaturales);

      Integer solicitadosEliminar
              = (Integer) request.getSession(false).getAttribute("IDsLength");
      Integer noEliminados = (Integer) request.getSession(false).getAttribute("noEliminados");

      if (solicitadosEliminar != null) {
        
        HttpSession e = request.getSession(false);
        e.removeAttribute("IDsLength");
        e.removeAttribute("noEliminados");
        
        if (noEliminados == solicitadosEliminar) {
          response.sendRedirect("ClientesNaturales.jsp?no_eliminados=all");
        }

        if (noEliminados < solicitadosEliminar) {
          response.sendRedirect("ClientesNaturales.jsp?eliminados=true&no_eliminados=true");
        }

      } else {
        response.sendRedirect("ClientesNaturales.jsp");

      }

    } catch (Exception e) {
      response.sendRedirect("PageError500.jsp");
    }

  }// </editor-fold>

}
