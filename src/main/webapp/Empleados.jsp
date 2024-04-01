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
                                
                                <hr>

                                <div class="d-flex justify-content-between">
                                    <div class="actions d-flex flex-row gap-3">
                                        <a href="SvGoToIngresarEmpleado" class="btn btn-primary d-flex flex-row gap-2 align-items-center" title="Ingresar registro">
                                            <i class="fa-solid fa-floppy-disk"></i>
                                        </a>
                                        <form action="SvBorrarEmpleado" method="post" id="borrarRegistrosEmpleados">
                                            <input type="text" name="idForDelete" id="idForDelete" hidden>
                                            <button type="submit" class="btn btn-danger d-flex flex-row gap-2 align-items-center" id="btnBorrarRegistro" title="Borrar registro" disabled>
                                                <i class="fa-solid fa-trash"></i>
                                            </button>
                                        </form>
                                        <form action="SvGoToActualizarEmpleado" method="post">
                                            <input type="text" name="idEmpleadoModificar" id="idEmpleadoModificar" hidden>
                                            <button type="submit" class="btn btn-warning d-flex flex-row gap-2 align-items-center" id="btnActualizarRegistro" title="Actualizar registro" disabled>
                                                <i class="fa-solid fa-pen-to-square"></i>
                                            </button>
                                        </form>
                                    </div>

                                    <div class="actions d-flex flex-row gap-3">
                                        <button class="btn btn-primary d-flex flex-row gap-2 align-items-center" id="btnMarcarRegistros" title="Marcar todos los registros">
                                            <i class="fa-solid fa-square-check"></i>
                                        </button>
                                        <button class="btn btn-primary d-flex flex-row gap-2 align-items-center" id="btnDesmarcarRegistros" title="Desmarcar todos los registros">
                                            <i class="fa-regular fa-square-check"></i>
                                        </button>
                                        <a href="SvGoToEmployesList" class="btn btn-success d-flex flex-row gap-2 align-items-center" title="Actualizar tabla">
                                            <i class="fa-solid fa-rotate-right"></i>
                                        </a>
                                    </div>
                                </div>

                                <hr>

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
                                            <th>Teléfono</th>
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
                                                <input class="form-check-input" type="checkbox" value="<%= emp.getId()%>" name="checkbox" id="flexCheckDefault" style="width: 20px; height: 20px">
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
        <script src="./assets/js/seleccionarRegistro.js"></script>
    </body>
</html>
