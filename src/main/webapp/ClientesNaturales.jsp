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
        <h1>Cliente Natural</h1>
        <nav>
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="SvGoToDashboard">Home</a>
            </li>
            <li class="breadcrumb-item">Cliente Natural</li>
            <li class="breadcrumb-item active">Visualizar clientes</li>
          </ol>
        </nav>
      </div><!-- End Page Title -->

      <section class="section">
        <div class="row">
          <div class="col-lg-12">

            <div class="card" id="card-datatable-empleados">
              <div class="card-body">
                <h5 class="card-title">Registro de clientes</h5>

                <hr>

                <!-- Botones de modificación de entrada de la tabla -->
                <div class="d-flex justify-content-between">
                  <div class="actions d-flex flex-row gap-3">

                    <form action="#" method="post" id="employModForm">
                      <input type="text" name="inIdEmMod" id="inIdEmMod" hidden>
                      <button type="submit" class="btn btn-secondary d-flex flex-row gap-2 align-items-center" id="btnActualizarRegistro" title="Actualizar registro" disabled>
                        <i class="fa-solid fa-pen-to-square"></i>
                      </button>
                    </form>

                  </div>

                  <!-- Botones de marcación de entrada y refresco -->
                  <div class="actions d-flex flex-row gap-3">

                    <!-- <label for="checkAll" class="btn btn-primary d-flex flex-row gap-2 align-items-center" title="Marcar todos los registros" id="btnCheckAll">
                      <i class="fa-regular fa-square-check"></i>
                    </label>
                    <input type="checkbox" name="checkAll" id="checkAll" hidden> -->

                    <a href="SvGoToClientesNaturales" class="btn btn-success d-flex flex-row gap-2 align-items-center" title="Actualizar tabla">
                      <i class="fa-solid fa-rotate-right"></i>
                    </a>

                  </div>
                </div>

                <hr>

                <div class="table-responsive">
                  <!-- Table with stripped rows -->
                  <table class="table datatable table-hover">
                    <%                                      List<ClienteNatural> clientesN = (List<ClienteNatural>) request.getSession().getAttribute("clientes-naturales");
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
                        <th>Correo Electrónico</th>
                        <th>Estado</th>
                      </tr>
                    </thead>
                    <tbody>
                      <%
                        Integer a = 0;
                        for (ClienteNatural client : clientesN) {
                          a++;
                      %>
                      <tr>
                        <td class="form-cheack">
                          <input class="form-check-input" type="checkbox" value="<%= client.getId()%>" name="checkbox" id="flexCheckDefault<%=a%>" style="width: 20px; height: 20px">
                        </td>
                        <td><%= client.getNombres()%></td>
                        <td><%= client.getApellidos()%></td>
                        <td><%= client.getCedula()%></td>
                        <td><%= client.getTelefono()%></td>
                        <td><%= client.getEmail()%></td>
                        <td><%= client.getEstado()%></td>
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
        </div>
      </section>

    </main>
    <%@include file="components/Footer.jsp" %>

    <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

    <%@include file="components/scripts.jsp" %>
    <script src="assets/js/seleccionarRegistro.js"></script>
  </body>
</html>
