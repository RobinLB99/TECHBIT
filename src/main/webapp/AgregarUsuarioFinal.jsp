<%@page import="com.robinlb.techbit.model.ClienteNatural"%>
<%@page import="java.util.List"%>
<%@page import="com.robinlb.techbit.model.Empleado"%>
<%@page import="com.robinlb.techbit.controllers.DateController"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cliente Natural</title>
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
        <h1>Agregar usuario final</h1>
        <nav>
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="SvGoToDashboard">Home</a>
            </li>
            <li class="breadcrumb-item">Usuarios</li>
            <li class="breadcrumb-item active">Agregar usuario final</li>
          </ol>
        </nav>
      </div><!-- End Page Title -->

      <section class="section">
        <div class="row">
          <div class="col-lg-12">

            <div class="card" id="card-datatable-empleados">
              <div class="card-body">
                <h5 class="card-title">Datos del usuario</h5>
                
                <%
                ClienteNatural cache = (ClienteNatural) request.getSession(false).getAttribute("usuario_cache");
                
                String cache_nombres = (cache != null) ? cache.getNombres() : "";
                String cache_apellidos = (cache != null) ? cache.getApellidos() : "";
                String cache_cedula = (cache != null) ? cache.getCedula() : "";
                String cache_telefono = (cache != null) ? cache.getTelefono() : "";
                String cache_correo = (cache != null) ? cache.getEmail() : "";
                String cache_ip = (cache != null) ? cache.getIpDirection() : "";
                String cache_mac = (cache != null) ? cache.getMacDirection() : "";
                %>

                <form action="SvIngresarUsuarioFinal" method="post" id="formdatafinaluser" class="row g-3">
                  <div class="col-md-6">
                    <label for="validationServer01" class="form-label">Nombres</label>
                    <input type="text" class="form-control" name="nombres" id="validationServer01" value="<%=cache_nombres%>" required>
                    <div class="valid-feedback">
                      Correcto!
                    </div>
                    <div class="invalid-feedback">
                      Campo vació!
                    </div>
                  </div>
                  <div class="col-md-6">
                    <label for="validationServer02" class="form-label">Apellidos</label>
                    <input type="text" class="form-control" name="apellidos" value="<%=cache_apellidos%>" id="validationServer02" required>
                    <div class="valid-feedback">
                      Correcto!
                    </div>
                    <div class="invalid-feedback">
                      Campo vació!
                    </div>
                  </div>
                  <div class="col-md-4">
                    <label for="validationServer03" class="form-label">Cédula</label>
                    <input type="text" class="form-control" name="cedula" value="<%=cache_cedula%>" id="validationServer03" required>
                    <div class="valid-feedback">
                      Correcto!
                    </div>
                    <div class="invalid-feedback">
                      Campo invalido! Verifique que el valor del campo cumpla con los requisitos.
                    </div>
                  </div>
                  <div class="col-md-4">
                    <label for="validationServer04" class="form-label">Teléfono</label>
                    <input type="text" class="form-control" name="telefono" value="<%=cache_telefono%>" id="validationServer04" required>
                    <div class="valid-feedback">
                      Correcto!
                    </div>
                    <div class="invalid-feedback">
                      Campo invalido! Verifique que el valor del campo cumpla con los requisitos.
                    </div>
                  </div>
                  <div class="col-md-4">
                    <label for="validationServer05" class="form-label">Correo electrónico</label>
                    <input type="email" class="form-control" name="correo" value="<%=cache_correo%>" id="validationServer05" required>
                    <div class="valid-feedback">
                      Correcto!
                    </div>
                    <div class="invalid-feedback">
                      Campo invalido! Verifique que el valor del campo cumpla con los requisitos.
                    </div>
                  </div>
                  <div class="col-md-6">
                    <label for="validationServer06" class="form-label">Dirección IP</label>
                    <input type="text" class="form-control" name="dir_ip" value="<%=cache_ip%>" id="validationServer06" required>
                    <div class="valid-feedback">
                      Correcto!
                    </div>
                    <div class="invalid-feedback">
                      Campo invalido! Verifique que el valor del campo cumpla con los requisitos.
                    </div>
                  </div>
                  <div class="col-md-6">
                    <label for="validationServer07" class="form-label">Dirección MAC</label>
                    <input type="text" class="form-control" name="dir_mac" value="<%=cache_mac%>" id="validationServer07" required>
                    <div class="valid-feedback">
                      Correcto!
                    </div>
                    <div class="invalid-feedback">
                      Campo invalido! Verifique que el valor del campo cumpla con los requisitos.
                    </div>
                  </div>
                  
                  <div class="col-12">
                    <button class="btn btn-primary" type="submit">Crear usuario</button>
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
    <script src="assets/js/seleccionarRegistro.js"></script>
    <script src="assets/js/validarUsuarioFinal.js"></script>
  </body>
</html>
