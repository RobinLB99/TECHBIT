package com.robinlb.techbit.servelets.usuarios.procesado;

import com.robinlb.techbit.controllers.LogicController;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Se ejecuta al iniciar la aplicación y verifica si existe algún usuario
 * registrado.
 */
@WebServlet(name = "SvVerificarExistenciaUsuarios", urlPatterns = {"/SvVerificarExistenciaUsuarios"})
public class SvVerificarExistenciaUsuarios extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);

    LogicController control = new LogicController();

    try {
      Long countUsers = control.contarUsuarios();

      if (countUsers > 0) {
        response.sendRedirect("Login.jsp");

      } else {
        response.sendRedirect("RegistrarRoot.jsp");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      response.sendRedirect("PageError500.jsp");
    }

  }

}
