<%@page import="com.robinlb.techbit.controllers.JSONController"%>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cliente Natural</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <%@include file="components/head.jsp" %>

    <script src="./assets/tinymce/js/tinymce/tinymce.min.js" referrerpolicy="origin"></script>
    <script>
      document.addEventListener("DOMContentLoaded", function () {
        tinymce.init({
          selector: 'textarea#description',
          license_key: 'gpl',
          placeholder: 'Detalla el problema aquí...',
          plugins: ['advlist', 'autolink', 'link', 'lists', 'charmap', 'preview', 'searchreplace', 'code', 'tables']
        });
      })
    </script>

  </head>
  <body>
    <%
      Usuario usuario = (Usuario) request.getSession(false).getAttribute("user");
    %>
    <%@include file="components/header-cliente.jsp" %>
    <%@include file="components/Sidebar.jsp" %>
    <main id="main" class="main">
      <div class="pagetitle">
        <h1>Crear ticket</h1>
        <nav>
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="SvGoToDashboard">Home</a>
            </li>
            <li class="breadcrumb-item">Ticket</li>
            <li class="breadcrumb-item active">Crear ticket</li>
          </ol>
        </nav>
      </div><!-- End Page Title -->

      <section class="section">
        <div class="row">
          <div class="col-lg-12">

            <div class="card" id="card-datatable-empleados">
              <div class="card-body">
                <h5 class="card-title">Nuevo ticket</h5>

                <form id="NewTicket" action="SvCrearTicket" method="post" enctype="multipart/form-data" class="row g-3 needs-validation" novalidate>

                  <div class="col-md-6">
                    <label for="titulo-ticket" class="form-label">Titulo</label>
                    <input type="text" class="form-control" name="titulo" id="titulo-ticket" required>
                    <div class="invalid-feedback">
                      Ingresa un titulo
                    </div>
                  </div>

                  <div class="col-md-6">
                    <label for="categoria" class="form-label">Categoría</label>
                    <select class="form-select" id="categoria" name="categoria" required>
                      <option selected disabled value="">Seleccionar categoría...</option>                         <%
                        JSONArray categorias = (JSONArray) request.getSession(false).getAttribute("categorias");
                        for (int i = 0; i < categorias.length(); i++) {
                          JSONObject object = categorias.getJSONObject(i);
                      %>
                      <option value="<%= object.getString("categoria") %>"><%= object.getString("categoria") %></option>                      
                      <%
                        }
                      %>
                    </select>
                    <div class="invalid-feedback">
                      Please select a valid state.
                    </div>
                  </div>

                  <div class="mb-3">
                    <label for="adjunto" class="form-label">Archivo adjunto</label>
                    <input type="file" class="form-control" name="adjunto" id="adjunto" aria-label="file example" required>
                    <div class="invalid-feedback">Debe ingresar un archivo válido</div>
                  </div>

                  <textarea name="description" id="description"></textarea>

                  <br>
                  <div class="d-flex justify-content-center">
                    <button type="submit" class="btn btn-primary" style="width: 150px;">Crear ticket</button>
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

    <script src="./assets/js/editor-ticket.js"></script>

  </body>
</html>
