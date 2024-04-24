package com.robinlb.techbit;

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
 * para el acceso a los recursos.
 *
 */
public class AuthenticationFilterColaborador implements Filter {

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
    
    AuthenticationFilterForClienteLog client_log = new AuthenticationFilterForClienteLog();

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;
    String requestURI = httpRequest.getRequestURI();

    HttpSession session = httpRequest.getSession(false);

    if (session == null || session.getAttribute("user") == null) { // Solo si la sesion es nula o el atributo user sea nulo;

      if (requestURI.equals("/TechBit/Login.html")) {
//        chain.doFilter(request, response);
        client_log.doFilter(request, response, chain);
      } else {
        httpResponse.sendRedirect("Login.html");
      }

    } else { // En caso de que la sesion no sea nula o el atributo user no sea nulo
      if (requestURI.equals("/TechBit/Login.jsp")) {
        httpResponse.sendRedirect("Dashboard.jsp");
      } else {
//        chain.doFilter(request, response);
        client_log.doFilter(request, response, chain);
      }
    }
  }

  public void destroy() {
  }

}
