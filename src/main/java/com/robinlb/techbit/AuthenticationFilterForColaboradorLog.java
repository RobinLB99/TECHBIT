package com.robinlb.techbit;

import com.robinlb.techbit.model.Usuario;
import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Filtro de autentificación que permite validar si existe una sesión activa
 * para el acceso a los recursos del cliente.
 *
 */
public class AuthenticationFilterForColaboradorLog implements Filter {

  public void init(FilterConfig fConfig) throws ServletException {
  }

  /**
   * El metodo doFilter, valida si existe una sesión activa. Redirege a Login en
   * caso de no existir una. Si existe, da acceso a los recursos. Los Servelets
   * estan escluidos de la validación.
   *
   * @param request
   * @param response
   * @param chain
   * @throws IOException
   * @throws ServletException
   */
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;
    HttpSession session = httpRequest.getSession(false);

    try {
      Usuario usuario = (Usuario) session.getAttribute("user");
      String typeUser = usuario.getPrivilegios();

      if (typeUser.equals("Administrador") || typeUser.equals("Estandar")) {

        httpResponse.sendRedirect("Dashboard.jsp");

      } else {

        chain.doFilter(request, response);

      }
    }
    catch (Exception e) {
      chain.doFilter(request, response);
    }
  }

  public void destroy() {
  }

}
