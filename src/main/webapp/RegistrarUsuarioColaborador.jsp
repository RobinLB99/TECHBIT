<%@page import="java.util.Collection"%>
<%@page import="com.robinlb.techbit.model.Empleado"%>
<%@page import="com.robinlb.techbit.model.Usuario"%>
<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de credenciales para técnico - TechBit</title>
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
        <h1>Registro de credencial</h1>
        <nav>
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="SvGoToDashboard">Home</a>
            </li>
            <li class="breadcrumb-item">Técnicos</li>
            <li class="breadcrumb-item">
              <a href="SvGoToUsuariosColaboradores">Administrar credenciales</a>
            </li>
            <li class="breadcrumb-item active">Registro de credencial</li>
          </ol>
        </nav>
      </div><!-- End Page Title -->

      <section class="section">
        <div class="row">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Registrar credencial</h5>
                <%                
                  Empleado colaborador = (Empleado) request.getSession(false).getAttribute("colaborador");
                %>
                <form class="row g-3" action="SvAsignarUsuarioColaborador" method="post" id="formCreateUserC">
                  <div class="col-md-4">
                    <hr>
                    <p><i>Datos del colaborador:</i></p>
                    <span>
                      <strong><%= colaborador.getNombres()%> <%= colaborador.getApellidos()%></strong>
                    </span>
                    <br>
                    <span><%= colaborador.getCargo()%> / <%= colaborador.getDepartamento()%></span>
                    <br>
                    <span>Sin usuario asignado</span>
                  </div>

                  <div class="col-md-5">
                    <hr>
                    <p><i>Datos del usuario:</i></p>

                    <label for="validationServerUsername" class="form-label">Nombre de usuario</label>
                    <div class="input-group has-validation">
                      <span class="input-group-text" id="inputGroupPrepend1">@</span>
                      <input type="text" class="form-control" id="validationServerUsername" name="validationServerUsername" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
                      <div id="validationServerUsernameFeedback" class="invalid-feedback">
                        El nombre de usuario debe tener ocho caracteres mínimos, contener al menos una letra mayúscula y al menos un dígito.
                      </div>
                    </div>

                    <label for="validationServerPassword" class="form-label mt-3">Contraseña</label>
                    <div class="input-group has-validation">
                      <span class="input-group-text" id="inputGroupPrepend2">
                        <i class="fa-solid fa-key"></i>
                      </span>
                      <input type="password" class="form-control" id="validationServerPassword" name="validationServerPassword" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
                      <label class="input-group-text btn btn-outline-secondary">
                        <input type="checkbox" name="" id="viewPasswordBtn" hidden>
                        <i class="fa-regular fa-eye-slash" id="iconEye"></i>
                      </label>
                      <div id="validationServerPasswordFeedback" class="invalid-feedback">
                        La contraseña debe poseer mínimo 12 caracteres. No debe contener espacios, puntos o comas. Debe tener al menos un carácter especial, al menos una letra mayúscula y al menos un dígito.
                      </div>
                    </div>

                    <label for="validationServerAccess" class="form-label mt-3">Privilegios</label>
                    <div class="input-group has-validation">
                      <span class="input-group-text" id="inputGroupPrepend3">
                        <i class="fa-solid fa-list-check"></i>
                      </span>
                      <select class="form-select" name="validationServerAccess" id="validationServerAccess" required aria-label="select example">
                        <option value="" selected>Seleccione una opción...</option>
                        <option value="Administrador">Administrador</option>
                        <option value="Estándar">Estandar</option>
                      </select>
                      <div class="invalid-feedback" id="validationServerAccessFeedback">Opción seleccionada invalida</div>
                    </div>

                  </div>

                  <div class="col-12 d-flex justify-content-end">
                    <button class="btn btn-primary" id="guardarUsuarioC" type="submit">Crear usuario</button>
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
    <script src="assets/js/validacionRegistroUsuarioColaborador.js"></script>

  </body>
</html>