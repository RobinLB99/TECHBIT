package com.robinlb.techbit.servelets;

import com.robinlb.techbit.controllers.LogicController;
import com.robinlb.techbit.model.Empleado;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Collection;

@WebServlet(name = "SvGoToEmployesList", urlPatterns = {"/SvGoToEmployesList"})
public class SvGoToEmployesList extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        LogicController control = new LogicController();

        try {
            Collection<Empleado> listaEmpleados = control.listaEmpleados();

            HttpSession es = request.getSession();
            es.setAttribute("listaEmpleados", listaEmpleados);
        
            response.sendRedirect("Empleados.jsp");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
        }

        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
