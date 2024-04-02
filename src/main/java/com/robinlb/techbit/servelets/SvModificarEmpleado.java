package com.robinlb.techbit.servelets;

import com.robinlb.techbit.controllers.DateController;
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
import java.util.Date;

/**
 * Servelet de para la modificación de un registro de empleado.
 */
@WebServlet(name = "SvModificarEmpleado", urlPatterns = {"/SvModificarEmpleado"})
public class SvModificarEmpleado extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * 
     * Metodo Post para la modificación del registro de empleado.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        LogicController control = new LogicController();
        DateController dateControl = new DateController();

        String stringID = (String) request.getParameter("inputId");
        String nombres = (String) request.getParameter("inputNombres");
        String apellidos = (String) request.getParameter("inputApellidos");
        String cedula = (String) request.getParameter("inputCedula");
        String telefono = (String) request.getParameter("inputTelefono");
        String correo = (String) request.getParameter("inputEmail");
        String stringFecha = (String) request.getParameter("inputNacimiento");
        String cargo = (String) request.getParameter("inputCargo");
        String depart = (String) request.getParameter("inputDepartamento");

        Date fecha =  dateControl.formatToDate(stringFecha);
        HttpSession mod = request.getSession();
        
        try {
            Empleado empleado = control.verEmpleado(Long.parseLong(stringID));
            empleado.setNombres(nombres);
            empleado.setApellidos(apellidos);
            empleado.setCedula(cedula);
            empleado.setTelefono(telefono);
            empleado.setFechaNacimiento(fecha);
            empleado.setCargo(cargo);
            empleado.setDepartamento(depart);
            
            control.actualizarEmpleado(empleado);
            
            mod.setAttribute("empModificado", true);
            
            response.sendRedirect("SvGoToEmployesList");
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            mod.setAttribute("empModificado", false);
            response.sendRedirect("SvGoToEmployesList");
        }

    }

}
