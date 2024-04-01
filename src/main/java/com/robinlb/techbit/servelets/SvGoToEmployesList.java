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
        Integer numNotDel = null;
        Integer lengthArray = null;

        /**
         * Persiste la lista de empleados desde la base de datos
         */
        try {
            Collection<Empleado> listaEmpleados = control.listaEmpleados();

            HttpSession es = request.getSession();
            es.setAttribute("listaEmpleados", listaEmpleados);

            /**
             * Toma el numero de registros no eliminados de la tabla empleados
             * mediante el atributo de sesión "numNoEliminados"
             */
            try {
                numNotDel = Integer.parseInt(
                    (String) request.getSession().getAttribute("numNoEliminados")
                );

            } catch (Exception ex) {System.out.println(ex.getMessage());}

            /**
             * Toma la longitud del la lista de empleados eliminados
             * mediante el atributo de sesión "arrIDsForDelLength"
             */
            try {
                lengthArray = (int) request.getSession().getAttribute("arrIDsForDelLength");

            } catch (Exception a) {System.out.println(a.getMessage());}

            /**
             * Redirecciona '/Empleados.jsp' y establece variables según
             * exista registros eliminados de la tabla empleado
             */
            if (numNotDel == null) {
                response.sendRedirect("Empleados.jsp");
            } else if (numNotDel == 0) {
                response.sendRedirect("Empleados.jsp?del=true&notDel=false");
            } else if (numNotDel > 0) {
                response.sendRedirect("Empleados.jsp?del=true&notDel=true");
            } else if (numNotDel == lengthArray) {
                response.sendRedirect("Empleados.jsp?del=false&notDel=true");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
