package com.robinlb.techbit.servelets.cliente.procesado;

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
@WebServlet(name = "SvIngresarUsuarioFinal", urlPatterns = {"/SvIngresarUsuarioFinal"})
public class SvIngresarUsuarioFinal extends HttpServlet {

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

    String nombres = (String) request.getParameter("nombres");
    String apellidos = (String) request.getParameter("apellidos");
    String cedula = (String) request.getParameter("cedula");
    String telefono = (String) request.getParameter("telefono");
    String correo = (String) request.getParameter("correo");
    String dirIp = (String) request.getParameter("dir_ip");
    String dirMac = (String) request.getParameter("dir_mac");

    LogicController control = new LogicController();

    ClienteNatural usuarioFinal = new ClienteNatural();
    usuarioFinal.setNombres(nombres);
    usuarioFinal.setApellidos(apellidos);
    usuarioFinal.setCedula(cedula);
    usuarioFinal.setTelefono(telefono);
    usuarioFinal.setEmail(correo);
    usuarioFinal.setIpDirection(dirIp);
    usuarioFinal.setMacDirection(dirMac);

    try {
      Long mac_registradas = control.contarClientePorMAC(dirMac);
      Long ip_registradas = control.contarClientesPorIP(dirIp);
      
      ClienteNatural recuperado = null;
      try {
        recuperado = control.buscarClienteNaturalPorNUI(cedula);
      } catch (Exception e) {}
      
      try {
        HttpSession u = request.getSession(false);
        u.setAttribute("usuario_cache", usuarioFinal);

        if (ip_registradas >= 1) {
          response.sendRedirect("AgregarUsuarioFinal.jsp?ip_registrada=true");
        }
        else if (mac_registradas >= 1) {
          response.sendRedirect("AgregarUsuarioFinal.jsp?mac_registrada=true");
        }
        else if (recuperado != null) {
          response.sendRedirect("AgregarUsuarioFinal.jsp?usuario_registrado=true");
        }
        else {
          control.crearClienteNatural(usuarioFinal);

          u.removeAttribute("usuario_cache");

          response.sendRedirect("SvGoToClientesNaturales");
        }

      } catch (Exception e) {
        response.sendRedirect("AgregarUsuarioFinal.jsp?create=error");
      }

    } catch (Exception e) {
      response.sendRedirect("PageError500.jsp");
    }

  }// </editor-fold>

}
