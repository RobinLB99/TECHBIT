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
        String isMod = null;

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
                String num = (String) request.getSession().getAttribute("numNoEliminados");
                numNotDel = Integer.parseInt(num);

            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            /**
             * Toma la longitud del la lista de empleados eliminados mediante el
             * atributo de sesión "arrIDsForDelLength"
             */
            try {
                lengthArray = (int) request.getSession().getAttribute("arrIDsForDelLength");

            }
            catch (Exception a) {
                System.out.println(a.getMessage());
            }

            /**
             * Toma el atributo de sesión para comprobar si se modifico algún
             * registro de empleado.
             */
            try {
                isMod = (String) request.getSession().getAttribute("empModificado");
            }
            catch (Exception b) {
                System.out.println(b.getMessage());
            }

            /**
             * Redirecciona '/Empleados.jsp' y establece variables según exista
             * registros eliminados de la tabla empleado
             */
            if (numNotDel == null) {
                if (isMod != null && isMod.equals("true")) {
                    response.sendRedirect("Empleados.jsp?mod=true");
                }
                
                response.sendRedirect("Empleados.jsp");
                
            } else if (numNotDel != null && numNotDel == 0) {
                response.sendRedirect("Empleados.jsp?del=true&notDel=false");
                
            } else if (numNotDel != null && numNotDel > 0) {
                response.sendRedirect("Empleados.jsp?del=true&notDel=true");
                
            } else if (numNotDel != null && numNotDel == lengthArray) {
                response.sendRedirect("Empleados.jsp?del=false&notDel=true");
            }

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
