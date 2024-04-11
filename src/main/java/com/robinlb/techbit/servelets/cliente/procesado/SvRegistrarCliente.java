package com.robinlb.techbit.servelets.cliente.procesado;

import com.robinlb.techbit.controllers.LogicController;
import com.robinlb.techbit.model.ClienteNatural;
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
@WebServlet(name = "SvRegistrarCliente", urlPatterns = {"/SvRegistrarCliente"})
public class SvRegistrarCliente extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
  }

  // <editor-fold defaultstate="collapsed">

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
    
    Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioClienteCrear");
    
    String nombres = (String) request.getParameter("inputNombres");
    String apellidos = (String) request.getParameter("inputApellidos");
    String cedula = (String) request.getParameter("inputCedula");
    String telefono = (String) request.getParameter("inputTelefono");
    String email = (String) request.getParameter("inputEmail");
    
    ClienteNatural cliente = new ClienteNatural();
    cliente.setNombres(nombres);
    cliente.setApellidos(apellidos);
    cliente.setCedula(cedula);
    cliente.setTelefono(telefono);
    cliente.setEmail(email);
    cliente.setEstado("Inactivo");
    
    try {
      control.crearClienteNatural(cliente);
      usuario.setClienteNatural(cliente);
      control.crearUsuario(usuario);
      
      HttpSession e = request.getSession(false);
      e.removeAttribute("usuarioClienteCrear");
      e.invalidate();
      
      response.sendRedirect("LoginCliente.jsp?user-created=true");
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
      
      HttpSession a = request.getSession(false);
      a.removeAttribute("usuarioClienteCrear");
      a.invalidate();
      
      response.sendRedirect("LoginCliente.jsp?user-created=false");
    }
    
    
  }// </editor-fold>

}
