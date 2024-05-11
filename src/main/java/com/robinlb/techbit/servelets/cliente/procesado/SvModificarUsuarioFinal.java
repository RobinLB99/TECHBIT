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
@WebServlet(name = "SvModificarUsuarioFinal", urlPatterns = {"/SvModificarUsuarioFinal"})
public class SvModificarUsuarioFinal extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
    
    String nombres = (String) request.getParameter("nombres");
    String apellidos = (String) request.getParameter("apellidos");
    String cedula = (String) request.getParameter("cedula");
    String correo = (String) request.getParameter("correo");
    String telefono = (String) request.getParameter("telefono");
    String direccionIP = (String) request.getParameter("dir_ip");
    String direccionMAC = (String) request.getParameter("dir_mac");
    
    ClienteNatural usuarioFinal
          = (ClienteNatural) request.getSession(false).getAttribute("usuarioModificar");
    
    usuarioFinal.setNombres(nombres);
    usuarioFinal.setApellidos(apellidos);
    usuarioFinal.setCedula(cedula);
    usuarioFinal.setEmail(correo);
    usuarioFinal.setTelefono(telefono);
    usuarioFinal.setIpDirection(direccionIP);
    usuarioFinal.setMacDirection(direccionMAC);
    
    try {
      control.editarClienteNaural(usuarioFinal);
      
      HttpSession a = request.getSession(false);
      a.removeAttribute("usuarioModificar");
      a.setAttribute("usuarioFinalModificado", "true");
      
      response.sendRedirect("SvGoToClientesNaturales");
      
    } catch (Exception e) {
      response.sendRedirect("ActuarizarUsuarioFinal.jsp?modificado=error");
    }

  }// </editor-fold>

}
