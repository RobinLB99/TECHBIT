package com.robinlb.techbit.servelets.auth;

import com.robinlb.techbit.controllers.LogicController;
import com.robinlb.techbit.controllers.PasswordSecurityService;
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
@WebServlet(name = "SvLoginCliente", urlPatterns = {"/SvLoginCliente"})
public class SvLoginCliente extends HttpServlet {

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

    String username = request.getParameter("nombre_usuario");
    String password = request.getParameter("contraseña");

    LogicController control = new LogicController();
    PasswordSecurityService secure = new PasswordSecurityService();

    try {
      Usuario usuario = control.verUsuarioPorNombreUsuario(username);

      if (usuario.getEmpleado() != null 
              || usuario.getClienteEmpresarial() != null) {
        response.sendRedirect("Login_Cliente.jsp?username=invalid");
        
      } else {
        boolean match = secure.matches(password, usuario.getContraseña());

        if (match) {

          HttpSession session = request.getSession();
          session.setAttribute("client-user", usuario);

          response.sendRedirect("C-Dashboard.jsp");

        } else {
          response.sendRedirect("Login_Cliente.jsp?password=incorrect");
        }

      }

    }
    catch (Exception e) {
      response.sendRedirect("Login_Cliente.jsp?username=invalid");
    }

  }// </editor-fold>

}
