package com.robinlb.techbit.servelets.usuarios.procesado;

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
 * Servelet para la creación de usuario cliente.
 * 
 * @author Robin
 */
@WebServlet(name = "SvCreateClientUser", urlPatterns = {"/SvCreateClientUser"})
public class SvCreateClientUser extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
  }

  // <editor-fold defaultstate="collapsed">

  /**
   * Metodo HTTP <code>POST</code>.
   * Crea el objeto Usuario y sus parametros y los guarda en un atributo de
   * sesión para su posterior uso.
   * Luego redirige a la pagina de ingreso de datos del cliente.
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
    
    String username = (String) request.getParameter("nombre_usuario");
    String password = (String) request.getParameter("contraseña");
    
    String securePassword = secure.encrypt(password);
    
    Usuario usuario = new Usuario();
    usuario.setNombreUsuario(username);
    usuario.setContraseña(securePassword);
    usuario.setPrivilegios("Estandar");
    
    HttpSession clientUserToCreate = request.getSession();
    clientUserToCreate.setAttribute("usuarioClienteCrear", usuario);
    
    response.sendRedirect("IngresarDatosCliente.jsp");
    
  }// </editor-fold>

}
