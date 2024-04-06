package com.robinlb.techbit.servelets.colaboradores.procesado;

import com.robinlb.techbit.controllers.DateController;
import com.robinlb.techbit.controllers.LogicController;
import com.robinlb.techbit.model.Empleado;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 *
 * @author Robin
 */
@WebServlet(name = "SvIngresarEmpleado", urlPatterns = {"/SvIngresarEmpleado"})
public class SvIngresarEmpleado extends HttpServlet {
    
    LogicController control = new LogicController();
    DateController dateController = new DateController();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String nombres = (String) request.getParameter("inputNombres");
        String apellidos = (String) request.getParameter("inputApellidos");
        String cedula = (String) request.getParameter("inputCedula");
        String telefono = (String) request.getParameter("inputTelefono");
        String email = (String) request.getParameter("inputEmail");
        String fecha = (String) request.getParameter("inputNacimiento");
        String departamento = (String) request.getParameter("inputDepartamento");
        String cargo = (String) request.getParameter("inputCargo");

        Date nacimiento = dateController.formatToDate(fecha);
        
        Empleado employ = new Empleado();
        employ.setNombres(nombres);
        employ.setApellidos(apellidos);
        employ.setCedula(cedula);
        employ.setTelefono(telefono);
        employ.setEmail(email);
        employ.setFechaNacimiento(nacimiento);
        employ.setDepartamento(departamento);
        employ.setCargo(cargo);
        employ.setTieneUsuarioAsignado(false);
        
        try {
            control.crearEmpleado(employ);
            response.sendRedirect("Dashboard.jsp?employ=create");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            response.sendRedirect("Dashboard.jsp?error=true");
        }
        
    }

}
