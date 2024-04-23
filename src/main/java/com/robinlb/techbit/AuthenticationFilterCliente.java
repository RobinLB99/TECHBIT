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
 * para el acceso a los recursos del cliente.
 *
 */
public class AuthenticationFilterCliente implements Filter {

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
    
    AuthenticationFilterForColaboradorLog co_log = new AuthenticationFilterForColaboradorLog();

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;
    String requestURI = httpRequest.getRequestURI();

    HttpSession session = httpRequest.getSession(false);

    if (session == null || session.getAttribute("user") == null) { // Solo si la sesion es nula o el atributo user sea nulo;

      if (requestURI.equals("/TechBit/Login_Cliente.jsp")) {
//        chain.doFilter(request, response);
        co_log.doFilter(request, response, chain);
      } else {
        httpResponse.sendRedirect("Login_Cliente.jsp");
      }

    } else { // En caso de que la sesion no sea nula o el atributo user no sea nulo
      if (requestURI.equals("/TechBit/Login_Cliente.jsp")) {
        httpResponse.sendRedirect("C-Dashboard.jsp");
      } else {
//        chain.doFilter(request, response);
        co_log.doFilter(request, response, chain);
      }
    }
  }

  public void destroy() {
  }

}
