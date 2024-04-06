package com.robinlb.techbit.servelets.auth;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * Servicio de cierre de sesión.
 */
@WebServlet(name = "SvLogout", urlPatterns = {"/SvLogout"})
public class SvLogout extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);

    HttpSession SessionActive = request.getSession(false);
    SessionActive.invalidate();
    
    response.sendRedirect("Login.jsp");
    
  }

}
