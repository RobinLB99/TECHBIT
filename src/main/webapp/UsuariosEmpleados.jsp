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
<html lang="es">

  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Usuarios/Empleados</title>
    <%@include file="/components/head.jsp" %>
  </head>

  <body>
    <%@include file="/components/header.jsp" %>
    <%@include file="/components/Sidebar.jsp" %>

    <main id="main" class="main">
      <div class="pagetitle">
        <h1>Usuarios</h1>
        <nav>
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="SvGoToDashboard">Home</a>
            </li>
            <li class="breadcrumb-item">Personal</li>
            <li class="breadcrumb-item active">Usuarios</li>
          </ol>
        </nav>
      </div><!-- End Page Title -->

      <section class="section">
        <div class="row">
          <div class="col-lg-12">
            <%
              Collection<Empleado> colaboresSinUsuario = (Collection<Empleado>) request.getSession().getAttribute("colaboradores-sin-usuario");
              Collection<Usuario> usuariosColaboradores = (Collection<Usuario>) request.getSession().getAttribute("usuarios-colaboradores");
            %>
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Usuarios de los colaboradores</h5>
                <div class="container-fluid">
                  <nav>
                    <div class="nav nav-underline" id="nav-tab" role="tablist">
                      <button class="nav-link active" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-home" type="button" role="tab" aria-controls="nav-home" aria-selected="true">Usuarios registrados</button>

                      <button class="nav-link" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-profile" type="button" role="tab" aria-controls="nav-profile" aria-selected="false">Colaboradores sin usuario</button>
                    </div>
                  </nav>

                  <div class="tab-content" id="nav-tabContent">

                    <!-- Tab Usuarios de Colaboradores -->
                    <%@include file="/components/Tab-Usuarios-Colaboradores.jsp" %>

                    <!-- Tab Colaboradores sin Usuarios -->
                    <%@include file="/components/Tab-Colaboradores-NoUsuario.jsp" %>
                    
                  </div>
                </div>
              </div>
            </div>

          </div>
        </div>
      </section>

    </main>
    <%@include file="/components/Footer.jsp" %>

    <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

    <%@include file="/components/scripts.jsp" %>
    <script src="./assets/js/seleccionarColaboradorSinUsuario.js"></script>

  </body>

</html>