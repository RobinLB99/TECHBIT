package com.robinlb.techbit.servelets.colaboradores.redireccionamiento;

import com.robinlb.techbit.controllers.LogicController;
import com.robinlb.techbit.model.Empleado;
import com.robinlb.techbit.model.Usuario;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 *
 */
@WebServlet(name = "SvGoToUsuariosColaboradores", urlPatterns = {"/SvGoToUsuariosColaboradores"})
public class SvGoToUsuariosColaboradores extends HttpServlet {

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
  }

  /**
   *
   * Obtine los registros de usuarios registrados de los colaboradores.
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);

    LogicController control = new LogicController();

    try {
      /**
       * Toma la lista de usuarios registrados de los colaboradores
       */
      Collection<Usuario> allUsers = control.listaUsuarios();
      Collection<Usuario> employUsers = new ArrayList<>();

      for (Usuario user : allUsers) {
        if (user.getEmpleado() != null) {
          employUsers.add(user);
        }
      }

      HttpSession usersc = request.getSession();
      usersc.setAttribute("usuarios-colaboradores", employUsers);

      /**
       * Toma la lista de los colaboradores que no poseen usuario registrado
       */
      Collection<Empleado> colaboradores = control.listaEmpleados();
      Collection<Empleado> sinUsuario = new ArrayList<>();

      for (Empleado emp : colaboradores) {
        if (emp.getTieneUsuarioAsignado() == false) {
          sinUsuario.add(emp);
        }
      }

      HttpSession colNotUser = request.getSession();
      colNotUser.setAttribute("colaboradores-sin-usuario", sinUsuario);

      response.sendRedirect("UsuariosEmpleados.jsp");

    }
    catch (Exception e) {
      response.sendRedirect("PageError500.jsp");
    }

  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }

}
