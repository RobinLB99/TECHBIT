package com.robinlb.techbit.servelets.colaboradores.procesado;

import com.google.gson.Gson;
import com.robinlb.techbit.controllers.LogicController;
import com.robinlb.techbit.model.Empleado;
import com.robinlb.techbit.model.Usuario;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@WebServlet(name = "SvBorrarEmpleado", urlPatterns = {"/SvBorrarEmpleado"})
public class SvBorrarEmpleado extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    LogicController control = new LogicController();
    Gson gson = new Gson();

    int numNotDel = 0;
    String jsonArrayId = (String) request.getParameter("idForDelete");
    /**
     * @param gson.fromJson(String json, Object.class) Transforma el String
     * tomado en un objeto List
     */
    List<String> IDs = (List<String>) gson.fromJson(jsonArrayId, Object.class);

    for (String id : IDs) {

      Long longID = Long.parseLong(id);
      System.out.println("ID: " + longID);

      try {
        Empleado empleadoEliminar = control.verEmpleado(longID);
        Usuario usuarioEliminar = control.verUsuarioPorEmpleado(empleadoEliminar);
        
        control.eliminarUsuario(usuarioEliminar.getUsuarioId());
        control.eliminarEmpleado(longID);

      } catch (Exception e) {
        numNotDel += 1;
        System.out.println(e.getMessage());
      }

    }

    HttpSession notDelete = request.getSession(false);
    notDelete.setAttribute("numNoEliminados", numNotDel);

    HttpSession arrIDsLength = request.getSession(false);
    arrIDsLength.setAttribute("arrIDsForDelLength", IDs.size());

    response.sendRedirect("SvGoToEmployesList");
  }

}
