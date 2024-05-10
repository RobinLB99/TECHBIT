package com.robinlb.techbit.servelets.cliente.procesado;

import com.google.gson.Gson;
import com.robinlb.techbit.controllers.LogicController;
import com.robinlb.techbit.model.ClienteNatural;
import com.robinlb.techbit.model.TicketSoporte;
import com.robinlb.techbit.model.Usuario;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author joel
 */
@WebServlet(name = "SvEliminarUsuarioFinal", urlPatterns = {"/SvEliminarUsuarioFinal"})
public class SvEliminarUsuarioFinal extends HttpServlet {

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
    Gson gson = new Gson();

    Integer notDelete = 0;

    String jsonArray = (String) request.getParameter("inIDUserForDelete");
    List<String> IDs = (List<String>) gson.fromJson(jsonArray, Object.class);

    // Elimina los usuarios finales según los IDs en la lista creada en la selección.
    for (String stringID : IDs) {
      Long id = Long.parseLong(stringID);

      ClienteNatural usuarioFinal = control.buscarClienteNatural(id);

      try {
        TicketSoporte ticket = control.buscarTicketPorClienteNatural(usuarioFinal);
        notDelete++;
      } catch (Exception a) {

        try {
          // Busca y elimina la credencial asignada al usuario final.
          Usuario credencial
                  = control.buscarUsuarioClienteNaturalPorClienteNatural(usuarioFinal);
          control.eliminarUsuario(credencial.getUsuarioId());
        } catch (Exception b) {
        }

        try {
          // Elimina el usuario final.
          control.eliminarClienteNatural(id);
        } catch (Exception c) {
          notDelete++;
        }

      }

    }

    System.out.println("No eliminados: " + notDelete);

    HttpSession nd = request.getSession(false);
    nd.setAttribute("noEliminados", notDelete);
    nd.setAttribute("IDsLength", IDs.size());

    response.sendRedirect("SvGoToClientesNaturales");
  }// </editor-fold>

}
