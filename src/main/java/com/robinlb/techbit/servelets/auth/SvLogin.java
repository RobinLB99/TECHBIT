package com.robinlb.techbit.servelets.auth;

import com.robinlb.techbit.controllers.JSONController;
import com.robinlb.techbit.controllers.LogicController;
import com.robinlb.techbit.controllers.PasswordSecurityService;
import com.robinlb.techbit.model.Usuario;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servicio de inicio de sesión
 */
@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {

  LogicController control = new LogicController();

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);

    PasswordSecurityService passwordSecure = new PasswordSecurityService();

    String username = (String) request.getParameter("nombre_usuario");
    String password = (String) request.getParameter("contraseña");

    try {
      Usuario usuario = control.verUsuarioPorNombreUsuario(username);
      boolean match = passwordSecure.matches(password, usuario.getContraseña());

      if (match) {
        HttpSession session = request.getSession();
        session.setAttribute("user", usuario);

        String user_rol = usuario.getPrivilegios();
        
        // Obtiene el contenido del JSON users/roles en resources
        JSONController jcontrol = new JSONController();
        JSONArray jsonArray = jcontrol.obtenerJSONArray("/users/roles.json");
        
        JSONArray functions = null;
        // Cicla y escoje el valor array de la clave "content" cuyo objeto tenga en el valor del rol de usuario en clave 'type'
        for (int i = 0; i < jsonArray.length(); i++) {
          JSONObject object = jsonArray.getJSONObject(i);
          if (object.get("type").equals(user_rol)) {
            functions = new JSONArray(object.getJSONArray("content"));
            break;
          }
        }

        session.setAttribute("functions_sidebar", functions);

        response.sendRedirect("Dashboard.jsp");

      } else {
        response.sendRedirect("Login.jsp?password=incorrect");
      }

    }
    catch (Exception e) {
      System.out.println(e.getMessage());
      response.sendRedirect("Login.jsp?user=false");
    }

  }

  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
