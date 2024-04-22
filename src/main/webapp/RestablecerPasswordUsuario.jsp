<%@page import="com.robinlb.techbit.model.Empleado"%>
<%@page import="com.robinlb.techbit.model.Usuario"%>
<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restablecer contraseña de usuario del colaborador</title>
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
        <h1>Restablecer contraseña</h1>
        <nav>
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="SvGoToDashboard">Home</a>
            </li>
            <li class="breadcrumb-item">Personal</li>
            <li class="breadcrumb-item">
              <a href="SvGoToUsuariosColaboradores">Usuarios</a>
            </li>
            <li class="breadcrumb-item active">Restablecer contraseña</li>
          </ol>
        </nav>
      </div><!-- End Page Title -->


      <section class="section">
        <div class="row">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Restablecimiento de contraseña</h5>
                <div class="container-fluid">
                  <%                    Usuario user = (Usuario) request.getSession(false).getAttribute("UserPassReset");
                  %>
                  <form class="row g-3" action="SvRestablecerContrase_a" method="post" id="formResetPasswordUser">
                    <div class="col-md-4">
                      <hr>
                      <p><i>Datos del usuario:</i></p>
                      <span>
                        <strong><%=user.getEmpleado().getNombres()%> <%=user.getEmpleado().getApellidos()%></strong>
                      </span>
                      <br>
                      <span><%= user.getNombreUsuario()%></span>
                      <br>
                      <span><%= user.getPrivilegios()%></span>
                    </div>

                    <div class="col-md-5">
                      <hr>
                      <p><i>Nueva contraseña:</i></p>

                      <label for="validationServerPassword" class="form-label mt-3">Contraseña</label>
                      <div class="input-group has-validation">
                        <span class="input-group-text" id="inputGroupPrepend2">
                          <i class="fa-solid fa-key"></i>
                        </span>
                        <input type="password" class="form-control" id="validationServerPassword" name="validationServerPassword" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
                        <label class="input-group-text btn btn-outline-secondary" id="btnViewPassword">
                          <input type="checkbox" name="" id="viewPasswordBtn" hidden>
                          <i class="fa-regular fa-eye-slash" id="iconEye"></i>
                        </label>
                        <div id="validationServerPasswordFeedback" class="invalid-feedback">
                          La contraseña debe tener como mínimo cinco caracteres y sin espacios.
                        </div>
                      </div>

                    </div>

                    <div class="col-12 d-flex justify-content-end">
                      <button class="btn btn-primary" id="guardarUsuarioC" type="submit">Restablecer</button>
                    </div>
                  </form>
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
    <script src="./assets/js/resetPasswordUserCol.js"></script>

  </body>

</html>