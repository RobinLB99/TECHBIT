package com.robinlb.techbit.servelets;

import com.robinlb.techbit.controllers.LogicController;
import com.robinlb.techbit.model.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * Servelet para el asignamiento de usuario al colaborador
 */
@WebServlet(name = "SvGoToOtorgarUsuarioColaborador", urlPatterns = {"/SvGoToOtorgarUsuarioColaborador"})
public class SvGoToOtorgarUsuarioColaborador extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
  }

  /**
   * Metodo <CODE>POST<CODE> donde se tomara el ID y buscar el colaborador
   * para asignarlo como un atributo de sesión y redirigir a la pagina
   * de registro de usuario del colaborador.
   * 
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException 
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
    
    LogicController control = new LogicController();
    
    String stringID = (String) request.getParameter("idColaboradorSinUsuario");
    Long id = Long.parseLong(stringID);
    
    try {
      Empleado colaborador = control.verEmpleado(id);
      
      HttpSession a = request.getSession();
      a.setAttribute("colaborador", colaborador);
      
      response.sendRedirect("RegistrarUsuarioColaborador.jsp");
      
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
      response.sendError(400, e.getMessage().toString());
    }
    
  }

}
