<%@page import="com.robinlb.techbit.model.Empleado"%>
<%@page import="com.robinlb.techbit.model.Usuario"%>
<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar el usuario del colaborador</title>
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
        <h1>Modificar usuario</h1>
        <nav>
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="SvGoToDashboard">Home</a>
            </li>
            <li class="breadcrumb-item">Personal</li>
            <li class="breadcrumb-item">
              <a href="SvGoToUsuariosColaboradores">Usuarios</a>
            </li>
            <li class="breadcrumb-item active">Modificar usuario</li>
          </ol>
        </nav>
      </div><!-- End Page Title -->

      <section class="section">
        <div class="row">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Modificación de usuario del colaborador</h5>
                <div class="container-fluid">
                  <%                    Usuario user = (Usuario) request.getSession(false).getAttribute("usuarioModificar");
                  %>
                  <form class="row g-3" action="SvModificarUsuarioColaborador" method="post" id="formModUser">
                    <div class="col-md-4">
                      <hr>
                      <p><i>Datos actuales del usuario:</i></p>
                      <span>
                        <strong><%=user.getEmpleado().getNombres()%> <%=user.getEmpleado().getApellidos()%></strong>
                      </span>
                      <br>
                      <span><%=user.getEmpleado().getCargo()%> / <%=user.getEmpleado().getDepartamento()%></span>
                      <br>
                      <span class="d-flex flex-row gap-3 align-items-center mt-2">
                        <i class="fa-regular fa-at"></i>
                        <span><%= user.getNombreUsuario()%></span>
                      </span>
                      <span class="d-flex flex-row gap-3 align-items-center">
                        <i class="fa-solid fa-list-check"></i>
                        <span><%= user.getPrivilegios()%></span>
                      </span>
                    </div>

                    <div class="col-md-5">
                      <hr>
                      <p><i>Nuevos datos del usuario:</i></p>

                      <!-- Username -->
                      <label for="validationServerUsername" class="form-label mt-3">Nombre de usuario</label>
                      <div class="input-group has-validation">
                        <span class="input-group-text" id="inputGroupPrepend2">
                          <i class="fa-solid fa-at"></i>
                        </span>
                        <input type="text" class="form-control" id="validationServerUsername" name="validationServerUsername" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" value="<%= user.getNombreUsuario()%>" required>
                        <div id="validationServerUsernameFeedback" class="invalid-feedback">
                          El nombre de usuario debe tener ocho caracteres mínimos, contener al menos una letra mayúscula y al menos un dígito.
                        </div>
                      </div>
                      <!-- end username -->

                      <!-- Privilegios -->
                      <label for="validationServerAccess" class="form-label mt-3">Privilegios</label>
                      <div class="input-group has-validation">
                        <span class="input-group-text" id="inputGroupPrepend3">
                          <i class="fa-solid fa-list-check"></i>
                        </span>
                        <input type="hidden" name="privilegios" value="<%= user.getPrivilegios()%>">
                        <select class="form-select" name="validationServerAccess" id="validationServerAccess" required aria-label="select example">
                          <option value="" selected>Seleccione una opción...</option>
                          <option value="Administrador">Administrador</option>
                          <option value="Estándar">Estándar</option>
                        </select>
                        <div class="invalid-feedback" id="validationServerAccessFeedback">Opción seleccionada invalida</div>
                      </div>
                      <!-- end privilegios -->

                    </div>

                    <div class="col-12 d-flex justify-content-end">
                      <button class="btn btn-primary" id="guardarUsuarioC" type="submit">Modificar</button>
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
    <script src="assets/js/validationModUserCol.js"></script>

  </body>

</html>