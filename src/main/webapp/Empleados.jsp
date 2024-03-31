<%@page import="com.robinlb.techbit.controllers.DateController"%>
<%@page import="java.util.Collection"%>
<%@page import="com.robinlb.techbit.model.Empleado"%>
<%@page import="com.robinlb.techbit.model.Usuario"%>
<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@include file="/components/ServicioComprobaciónSesionActiva.jsp" %>
<%  Usuario usuario = (Usuario) request.getSession().getAttribute("logUser");
    String username = (usuario.getNombreUsuario().equals("root"))
            ? "Administrador"
            : usuario.getNombreUsuario();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleados</title>
        <meta content="" name="description">
        <meta content="" name="keywords">
        <%@include file="/components/head.jsp" %>
    </head>
    <body>
        <%@include file="/components/header.jsp" %>
        <%@include file="/components/Sidebar.jsp" %>
        <main id="main" class="main">
            <div class="pagetitle">
                <h1>Empleados</h1>
                <nav>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="SvGoToDashboard">Home</a></li>
                        <li class="breadcrumb-item"><a href="#">Empleados</a></li>
                        <li class="breadcrumb-item active">Lista de empleados</li>
                    </ol>
                </nav>
            </div><!-- End Page Title -->

            <section class="section">
                <div class="row">
                    <div class="col-lg-12">

                        <div class="card" id="card-datatable-empleados">
                            <div class="card-body">
                                <h5 class="card-title">Registro de empleados</h5>
                                <p>Add lightweight datatables to your project with using the <a href="https://github.com/fiduswriter/Simple-DataTables" target="_blank">Simple DataTables</a> library. Just add <code>.datatable</code> class name to any table you wish to conver to a datatable. Check for <a href="https://fiduswriter.github.io/simple-datatables/demos/" target="_blank">more examples</a>.</p>

                                <!-- Table with stripped rows -->
                                <table class="table datatable table-hover">
                                    <%
                                        Collection<Empleado> empleados = (Collection<Empleado>) request.getSession().getAttribute("listaEmpleados");
                                        DateController dateControl = new DateController();
                                    %>
                                    <thead>
                                        <tr>
                                            <th></th>
                                            <th>
                                                <b>N</b>ombres
                                            </th>
                                            <th>
                                                <b>A</b>pellidos
                                            </th>
                                            <th>Cédula</th>
                                            <th>teléfono</th>
                                            <th>Correo Electronico</th>
                                            <th data-type="date" data-format="YYYY/MM/DD">Fecha Nacimiento</th>
                                            <th>Cargo</th>
                                            <th>Departamento</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            for (Empleado emp : empleados) {
                                        %>
                                        <tr>
                                            <td class="form-cheack">
                                                <input class="form-check-input" type="checkbox" value="<%= emp.getId()%>" id="flexCheckDefault" style="width: 20px; height: 20px">
                                            </td>
                                            <td><%= emp.getNombres()%></td>
                                            <td><%= emp.getApellidos()%></td>
                                            <td><%= emp.getCedula()%></td>
                                            <td><%= emp.getTelefono()%></td>
                                            <td><%= emp.getEmail()%></td>
                                            <td><%= dateControl.dateToString(emp.getFechaNacimiento())%></td>
                                            <td><%= emp.getCargo()%></td>
                                            <td><%= emp.getDepartamento()%></td>
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                                <!-- End Table with stripped rows -->

                            </div>
                        </div>

                    </div>
                </div>
            </section>

        </main>
        <%@include file="/components/Footer.jsp" %>

        <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

        <%@include file="/components/scripts.jsp" %>
    </body>
</html>
