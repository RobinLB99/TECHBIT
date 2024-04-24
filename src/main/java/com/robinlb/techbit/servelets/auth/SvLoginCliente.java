package com.robinlb.techbit.servelets.auth;

import com.robinlb.techbit.controllers.JSONController;
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
import org.json.JSONArray;
import org.json.JSONObject;

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
      
      if (!usuario.getPrivilegios().equals("Cliente")) {
        response.sendRedirect("Login_Cliente.html?username=invalid");
        
      } else {
        boolean match = secure.matches(password, usuario.getContraseña());
        
        if (match) {
          
          try {
            JSONController jcontrol = new JSONController();
            JSONArray json = jcontrol.obtenerJSONArray("/users/roles.json");
            JSONArray funciones = null;
            
            for (int i = 0; i < json.length(); i++) {
              JSONObject object = json.getJSONObject(i);
              if (object.getString("type").equals("Cliente")) {
                funciones = object.getJSONArray("content");
              }
            }
            
            HttpSession session = request.getSession();
            session.setAttribute("user", usuario);
            session.setAttribute("functions_sidebar", funciones);
            
            response.sendRedirect("C-Dashboard.jsp");
          }
          catch (Exception e) {
            response.sendRedirect("PageError500.jsp");
          }
          
        } else {
          response.sendRedirect("Login_Cliente.html?password=incorrect");
        }
        
      }
      
    }
    catch (Exception e) {
      response.sendRedirect("Login_Cliente.jsp?username=invalid");
    }
    
  }// </editor-fold>

}
