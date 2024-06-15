<%@page import="java.util.List"%>
<%@page import="java.util.Collection"%>
<%@page import="com.robinlb.techbit.model.Empleado"%>
<%@page import="com.robinlb.techbit.model.Usuario"%>
<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Usuarios/Empleados</title>
    <%@include file="components/head.jsp" %>
  </head>

  <body>
    <%
      Usuario usuario = (Usuario) request.getSession(false).getAttribute("user");
    %>
    <%@include file="components/header.jsp" %>
    <%@include file="components/Sidebar.jsp" %>

    <main id="main" class="main">
      <div class="pagetitle">
        <h1>Tickets no asignados</h1>
        <nav>
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="SvGoToDashboard">Home</a>
            </li>
            <li class="breadcrumb-item">Tickets</li>
            <li class="breadcrumb-item active">No asignados</li>
          </ol>
        </nav>
      </div><!-- End Page Title -->


      <section class="section">
        <div class="row">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Tickets</h5>
                <div class="container-fluid">

                  <!-- Tab Usuarios Finales con credenciales -->
                  <%@include file="/components/TicketsList-NoAsignados.jsp" %>
                  
                </div>
              </div>
            </div>

          </div>
        </div>
      </section>

    </main>
    <%@include file="components/Footer.jsp" %>

    <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

    <%@include file="components/scripts.jsp" %>
    <script src="assets/js/seleccionarColaboradorSinUsuario.js"></script>
    <script src="assets/js/seleccionarUsuariosColaboradores.js"></script>
    <script src="assets/js/showdetailsticket.js"></script>
    <script src="assets/js/confirmar-asignacion.js"></script>

  </body>

</html>