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
public class AuthenticationFilter implements Filter {

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
    String requestURI = httpRequest.getRequestURI();

    HttpSession session = httpRequest.getSession(false);

    if (session == null || session.getAttribute("user") == null 
            || session.getAttribute("usuario-cliente") == null) {

      if (requestURI.equals("/TechBit/")) {
        httpResponse.sendRedirect("index.jsp");

      } else if (requestURI.contains("/RegistrarRoot.jsp")
              || requestURI.contains("/IngresarDatosCliente.jsp")
              || requestURI.contains("/SvRegistrarCliente")
              || requestURI.contains("/SvCreateClientUser")
              || requestURI.contains("/Login.jsp")
              || requestURI.contains("LoginCliente.jsp")
              || requestURI.contains("/SvLogin")
              || requestURI.contains("/SvVerificarExistenciaUsuarios")
              || requestURI.contains("/SvCreateRoot")
              || requestURI.contains(".css")
              || requestURI.contains(".ttf")
              || requestURI.contains(".woff2")
              || requestURI.contains(".js")
              || requestURI.contains("index.jsp")
              || requestURI.contains("Main.html")) {
        chain.doFilter(request, response);

      } else {
        httpResponse.sendRedirect("Login.jsp");
      }

    } else if (requestURI.equals("/TechBit/Login.jsp")
            || requestURI.contains("LoginCliente.jsp")
            || requestURI.contains("/SvCreateClientUser")
            || requestURI.contains("/SvRegistrarCliente")
            || requestURI.contains("/IngresarDatosCliente.jsp")
            || requestURI.contains("/SvLoginCliente")
            || requestURI.contains("index.jsp")
            || requestURI.contains("Main.html")
            || requestURI.contains("/RegistrarRoot.jsp")
            || requestURI.contains("/Login.jsp")
            || requestURI.contains("/SvLogin")
            || requestURI.contains("/SvVerificarExistenciaUsuarios")
            || requestURI.contains("/SvCreateRoot")
            && httpRequest.getSession(false).getAttribute("user") != null) {
      httpResponse.sendRedirect("Dashboard.jsp");

    } else if (requestURI.contains("/SvLoginCliente")
            && httpRequest.getSession(false).getAttribute("user") != null) {
      httpResponse.sendRedirect("Dashboard-Cliente.jsp");
    }else {
      chain.doFilter(request, response);
    }
  }

  public void destroy() {
  }

}
