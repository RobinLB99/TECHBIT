package com.robinlb.techbit.servelets.usuarios.procesado;

import com.robinlb.techbit.controllers.LogicController;
import com.robinlb.techbit.controllers.PasswordSecurityService;
import com.robinlb.techbit.model.ClienteNatural;
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
@WebServlet(name = "SvRegistrarCuentaCliente", urlPatterns = {"/SvRegistrarCuentaCliente"})
public class SvRegistrarCuentaCliente extends HttpServlet {

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

    String nui = (String) request.getParameter("numero_identidad");
    String username = (String) request.getParameter("nombre_usuario");
    String password = (String) request.getParameter("contraseña");

    LogicController control = new LogicController();
    PasswordSecurityService secure = new PasswordSecurityService();

    String securePassword = secure.encrypt(password);

    try {

      ClienteNatural cliente = control.buscarClienteNaturalPorNUI(nui);

      if (cliente != null) {
        Usuario usuario = null;
        try {
          usuario = control.verUsuarioPorNombreUsuario(username);
        } catch (Exception a) {
        }

        if (usuario == null) {

          usuario = new Usuario();
          usuario.setNombreUsuario(username);
          usuario.setContraseña(securePassword);
          usuario.setPrivilegios("Estandar");
          usuario.setClienteNatural(cliente);

          try {
            control.crearUsuario(usuario);
            response.sendRedirect("Login_Cliente.jsp?account=create");
          } catch (Exception a) {
            response.sendRedirect("CreateClientAccount.html?create_account=error");
          }

        } else {
          response.sendRedirect("CreateClientAccount.html?existe_usuario=true");
        }

      } else {
        // This part may not be reached if buscarClienteNaturalPorNUI throws an exception
        response.sendRedirect("CreateClientAccount.html?existe_cliente=false");
      }

    } catch (jakarta.persistence.NoResultException e) {
        // This catch block handles the specific case where the NUI does not find any client
        response.sendRedirect("CreateClientAccount.html?existe_cliente=false");
    } catch (Exception e) {
        // This is a generic catch block for other unexpected errors
//        System.out.println("Exception: " + e.getMessage());
        response.sendRedirect("PageError500.jsp");
    }

  }// </editor-fold>

}
