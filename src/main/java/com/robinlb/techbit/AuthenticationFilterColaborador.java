package com.robinlb.techbit;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Filtro de autentificación que permite validar si existe una sesión activa
 * para el acceso a los recursos.
 *
 */
public class AuthenticationFilterColaborador implements Filter {

  public void init(FilterConfig fConfig) throws ServletException {}

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
  public void doFilter(
    ServletRequest request,
    ServletResponse response,
    FilterChain chain
  ) throws IOException, ServletException {
    AuthenticationFilterForClienteLog client_log =
      new AuthenticationFilterForClienteLog();

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;
    String requestURI = httpRequest.getRequestURI();

    HttpSession session = httpRequest.getSession(false);

    String contextPath = httpRequest.getContextPath();
    String loginPageURI = contextPath + "/Login.jsp";
    String dashboardPageURI = contextPath + "/Dashboard.jsp";

    if (session == null || session.getAttribute("user") == null) {
      // User is NOT authenticated
      if (requestURI.equals(loginPageURI)) {
        chain.doFilter(request, response); // Allow Login.jsp to be rendered for unauthenticated users
      } else {
        httpResponse.sendRedirect(loginPageURI); // Redirect to Login.jsp if trying to access protected resource
      }
    } else {
      // User IS authenticated
      if (requestURI.equals(loginPageURI)) {
        httpResponse.sendRedirect(dashboardPageURI); // Redirect to Dashboard.jsp if authenticated and trying to access login page
      } else {
        chain.doFilter(request, response); // Allow access to protected resources for authenticated users
      }
    }
  }

  public void destroy() {}
}
