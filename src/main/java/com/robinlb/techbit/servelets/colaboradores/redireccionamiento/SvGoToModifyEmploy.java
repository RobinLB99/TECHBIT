package com.robinlb.techbit.servelets.colaboradores.redireccionamiento;

import com.robinlb.techbit.controllers.LogicController;
import com.robinlb.techbit.model.Empleado;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "SvGoToModifyEmploy", urlPatterns = {"/SvGoToModifyEmploy"})
public class SvGoToModifyEmploy extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        LogicController control = new LogicController();

        String stringID = (String) request.getParameter("inIdEmMod");
        Long id = Long.parseLong(stringID);

        try {
            Empleado empleado = control.verEmpleado(id);
            
            HttpSession emp = request.getSession();
            emp.setAttribute("empleadoModificar", empleado);
            
            response.sendRedirect("ActualizarEmpleado.jsp");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
