<%@page import="com.robinlb.techbit.model.ClienteNatural"%>
<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%
  ClienteNatural usuarioFinal
          = (ClienteNatural) request.getSession(false).getAttribute("usuarioModificar");
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Dashboard - TechBit</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

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
        <h1>Modificación de personal</h1>
        <nav>
          <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="SvGoToDashboard">Home</a></li>
            <li class="breadcrumb-item">Usuarios</li>
            <li class="breadcrumb-item">
              <a href="SvGoToClientesNaturales">Listado de usuarios</a>
            </li>
            <li class="breadcrumb-item active">Actualizar usuario</li>
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
                <form action="SvModificarUsuarioFinal" method="post" id="formdatafinaluser" class="row g-3">
                  <div class="col-md-6">
                    <label for="validationServer01" class="form-label">Nombres</label>
                    <input type="text" class="form-control" name="nombres" id="validationServer01" value="<%= usuarioFinal.getNombres() %>" required>
                    <div class="valid-feedback">
                      Correcto!
                    </div>
                    <div class="invalid-feedback">
                      Campo vació!
                    </div>
                  </div>
                  <div class="col-md-6">
                    <label for="validationServer02" class="form-label">Apellidos</label>
                    <input type="text" class="form-control" name="apellidos" value="<%= usuarioFinal.getApellidos() %>" id="validationServer02" required>
                    <div class="valid-feedback">
                      Correcto!
                    </div>
                    <div class="invalid-feedback">
                      Campo vació!
                    </div>
                  </div>
                  <div class="col-md-4">
                    <label for="validationServer03" class="form-label">Cédula</label>
                    <input type="text" class="form-control" name="cedula" value="<%= usuarioFinal.getCedula() %>" id="validationServer03" required>
                    <div class="valid-feedback">
                      Correcto!
                    </div>
                    <div class="invalid-feedback">
                      Campo invalido! Verifique que el valor del campo cumpla con los requisitos.
                    </div>
                  </div>
                  <div class="col-md-4">
                    <label for="validationServer04" class="form-label">Teléfono</label>
                    <input type="text" class="form-control" name="telefono" value="<%= usuarioFinal.getTelefono() %>" id="validationServer04" required>
                    <div class="valid-feedback">
                      Correcto!
                    </div>
                    <div class="invalid-feedback">
                      Campo invalido! Verifique que el valor del campo cumpla con los requisitos.
                    </div>
                  </div>
                  <div class="col-md-4">
                    <label for="validationServer05" class="form-label">Correo electrónico</label>
                    <input type="email" class="form-control" name="correo" value="<%= usuarioFinal.getEmail() %>" id="validationServer05" required>
                    <div class="valid-feedback">
                      Correcto!
                    </div>
                    <div class="invalid-feedback">
                      Campo invalido! Verifique que el valor del campo cumpla con los requisitos.
                    </div>
                  </div>
                  <div class="col-md-6">
                    <label for="validationServer06" class="form-label">Dirección IP</label>
                    <input type="text" class="form-control" name="dir_ip" value="<%= usuarioFinal.getIpDirection() %>" id="validationServer06" required>
                    <div class="valid-feedback">
                      Correcto!
                    </div>
                    <div class="invalid-feedback">
                      Campo invalido! Verifique que el valor del campo cumpla con los requisitos.
                    </div>
                  </div>
                  <div class="col-md-6">
                    <label for="validationServer07" class="form-label">Dirección MAC</label>
                    <input type="text" class="form-control" name="dir_mac" value="<%= usuarioFinal.getMacDirection() %>" id="validationServer07" required>
                    <div class="valid-feedback">
                      Correcto!
                    </div>
                    <div class="invalid-feedback">
                      Campo invalido! Verifique que el valor del campo cumpla con los requisitos.
                    </div>
                  </div>

                  <div class="col-12">
                    <button class="btn btn-primary" type="submit">Modificar usuario</button>
                  </div>
                </form>

              </div>
            </div>

          </div>

        </div>
      </section>

    </main>

    <%@include file="components/Footer.jsp" %>

    <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

    <%@include file="components/scripts.jsp" %>
    <script src="assets/js/validarUsuarioFinal.js"></script>
  </body>
</html>

