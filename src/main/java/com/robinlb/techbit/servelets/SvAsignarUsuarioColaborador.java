package com.robinlb.techbit.servelets;

import com.robinlb.techbit.controllers.LogicController;
import com.robinlb.techbit.controllers.PasswordSecurityService;
import com.robinlb.techbit.model.Empleado;
import com.robinlb.techbit.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Robin
 */
@WebServlet(name = "SvAsignarUsuarioColaborador", urlPatterns = {"/SvAsignarUsuarioColaborador"})
public class SvAsignarUsuarioColaborador extends HttpServlet {

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
    PasswordSecurityService secure = new PasswordSecurityService();

    Usuario usuario = new Usuario();
    Empleado colaborador = (Empleado) request.getSession().getAttribute("colaborador");

    String username = (String) request.getParameter("validationServerUsername");
    String password = (String) request.getParameter("validationServerPassword");
    String access = (String) request.getParameter("validationServerAccess");

    String securePassword = secure.encrypt(password);

    usuario.setNombreUsuario(username);
    usuario.setContraseña(securePassword);
    usuario.setPrivilegios(access);

    try {
      control.crearUsuario(usuario);

      usuario.setEmpleado(colaborador);
      control.actualizarUsuario(usuario);

      colaborador.setTieneUsuarioAsignado(true);
      control.actualizarEmpleado(colaborador);

      response.sendRedirect("SvGoToUsuariosColaboradores");
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
      response.sendError(500, e.getMessage().toString());
    }

  }

}
