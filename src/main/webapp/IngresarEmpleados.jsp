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
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Dashboard - TechBit</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <%@include file="/components/head.jsp" %>
    </head>
    <body>
        <%@include file="/components/header.jsp" %>

        <%@include file="/components/Sidebar.jsp" %>

        <main id="main" class="main">
            <div class="pagetitle">
                <h1>Ingreso de personal</h1>
                <nav>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="Dashboard.jsp">Home</a></li>
                        <li class="breadcrumb-item">Personal</li>
                        <li class="breadcrumb-item active">Ingreso</li>
                    </ol>
                </nav>
            </div><!-- End Page Title -->

            <section class="section">
                <div class="row">
                    <div class="col-md-auto">

                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Datos personales</h5>

                                <!-- Multi Columns Form -->
                                <form class="row g-3" id="SendEmployForm" action="SvIngresarEmpleado" method="post">
                                    <div class="col-md-6">
                                        <label for="inputNombres" class="form-label">Nombres</label>
                                        <input type="text" class="form-control" id="inputNombres" name="inputNombres">
                                    </div>
                                    <div class="col-md-6">
                                        <label for="inputApellidos" class="form-label">Apellidos</label>
                                        <input type="text" class="form-control" id="inputApellidos" name=inputApellidos>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="inputCedula" class="form-label">N. Cedula</label>
                                        <input type="text" class="form-control" id="inputCedula" name="inputCedula">
                                    </div>
                                    <div class="col-md-6">
                                        <label for="inputTelefono" class="form-label">N. Telefono</label>
                                        <input type="tel" class="form-control" id="inputTelefono" name="inputTelefono">
                                    </div>
                                    <div class="col-12">
                                        <label for="inputEmail" class="form-label">Email</label>
                                        <input type="email" class="form-control" id="inputEmail" name="inputEmail" placeholder="prueba.123@email.com">
                                    </div>
                                    <div class="col-12">
                                        <label for="inputNacimiento" class="form-label">Fecha de Nacimiento</label>
                                        <input type="date" class="form-control" id="inputNacimiento" name="inputNacimiento" placeholder="">
                                    </div>
                                    <div class="col-md-6">
                                        <label for="inputCargo" class="form-label">Cargo</label>
                                        <select class="form-select" name="inputCargo"
                                        id="inputCargo">
                                            <option value="" selected >Escoja...</option>
                                            <option value="Ingeniero de Soporte Jr">Ingeniero de Soporte Jr</option>
                                            <option value="Ingeniero de Soporte Ssr">Ingeniero de Soporte Ssr</option>
                                            <option value="Ingeniero de Soporte Sr">Ingeniero de Soporte Sr</option>
                                            <option value="Supervisor">Supervisor</option>
                                        </select>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="inputDepartamento" class="form-label">Departamento</label>
                                        <select class="form-select" name="inputDepartamento" id="inputDepartamento">
                                            <option value="" selected >Escoja...</option>
                                            <option value="Soporte N1">Soporte N1</option>
                                            <option value="Soporte N2">Soporte N2</option>
                                            <option value="Soporte N3">Soporte N3</option>
                                        </select>
                                    </div>
                                    <div class="col-12">
                                    </div>
                                    <div class="text-center">
                                        <button type="submit" class="btn btn-primary">Ingresar</button>
                                        <button type="reset" class="btn btn-secondary">Limpiar</button>
                                    </div>
                                </form><!-- End Multi Columns Form -->

                            </div>
                        </div>

                    </div>

                </div>
            </section>

        </main>

        <%@include file="/components/Footer.jsp" %>

        <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

        <%@include file="/components/scripts.jsp" %>
        <script src="assets/js/ValidateFormEmploy.js"></script>
    </body>
</html>
