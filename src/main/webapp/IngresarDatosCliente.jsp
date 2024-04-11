<%@page contentType="text/html" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">

<head>
	<meta charset="utf-8" />
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<title>Register root Account</title>
	<meta content="" name="description" />
	<meta content="" name="keywords" />

	<%@include file="components/head.jsp" %>
</head>

<body>
	<main>
		<div class="container-fluid d-flex flex-column justify-content-center align-items-center" style="height: 100vh !important;">
      <div class="d-flex justify-content-center py-4">
        <a href="#" class="logo d-flex align-items-center w-auto">
          <img src="assets/img/logo.png" alt="" />
          <span class="d-none d-lg-block">TechBit</span>
        </a>
      </div>
			<div class="card">
        <div class="card-body">
          <h5 class="card-title">Ingresar datos personales</h5>
          <form id="formDataCliente" class="row g-3" action="SvRegistrarCliente" method="post">
            <div class="col-md-6">
              <label for="inputNombres" class="form-label">Nombres</label>
              <input type="text" class="form-control" id="inputNombres" name="inputNombres">
            </div>
            <div class="col-md-6">
                <label for="inputApellidos" class="form-label">Apellidos</label>
                <input type="text" class="form-control" id="inputApellidos" name=inputApellidos>
            </div>
            <div class="col-md-6">
                <label for="inputCedula" class="form-label">N. Cédula</label>
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
            <div class="text-center">
                <button type="submit" class="btn btn-primary">Ingresar</button>
                <button type="reset" class="btn btn-secondary">Limpiar</button>
            </div>
          </form>
        </div>
      </div>
		</div>
	</main>
	<!-- End #main -->

	<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
			class="bi bi-arrow-up-short"></i></a>
	<%@include file="components/scripts.jsp" %>
  <script src="assets/js/ValidarDatosCliente.js"></script>
	
</body>

</html>