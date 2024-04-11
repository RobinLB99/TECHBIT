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
		<div class="container">
			<section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">
							<div class="d-flex justify-content-center py-4">
								<a href="#" class="logo d-flex align-items-center w-auto">
									<img src="assets/img/logo.png" alt="" />
									<span class="d-none d-lg-block">TechBit</span>
								</a>
							</div>
							<!-- End Logo -->

							<div class="card mb-3">
								<div class="card-body">
									<div class="pt-4 pb-2">
										<h5 class="card-title text-center pb-0 fs-4">
											Registrar usuario cliente
										</h5>
										<p class="text-center small">
											Registra un usuario y contraseña para tu cuenta.
										</p>
									</div>

									<form class="row g-3 needs-validation" method="post" action="SvCreateClientUser" id="formCreateRoot">
										<div class="col-12">
											<div class="invalid-feedback">
												Please, enter your name!
											</div>
										</div>

										<!-- Nombre de usuario -->
										<div class="col-12">
											<label for="yourUsername" class="form-label">Nombre de usuario</label>
											<div class="input-group has-validation">
												<span class="input-group-text" id="inputGroupPrepend">
													<i class="fa-solid fa-at"></i>
												</span>
												<input type="text" name="nombre_usuario" class="form-control" id="yourUsername"
													required/>
												<div class="invalid-feedback">
													Por favor, ingresa un nombre de usuario.
												</div>
											</div>
										</div>

										<!-- Contraseña -->
										<div class="col-12">
											<label for="yourPassword" class="form-label">Contraseña</label>
											<div class="input-group has-validation" id="passwordGroup">
												<span class="input-group-text" id="inputGroupPrepend">
													<i class="fa-solid fa-key"></i>
												</span>
												<input type="password" name="contraseña" class="form-control" id="yourPassword" required />
                        <label class="input-group-text btn btn-outline-secondary" id="btnMostrar1">
                          <input type="checkbox" id="check1" hidden>
                          <i class="fa-solid fa-eye-slash"></i>
                        </label>
												<div class="invalid-feedback">
													Por favor, introduce una contraseña valida!
												</div>
											</div>
										</div>

										<!-- Repetición de contraseña -->
										<div class="col-12">
											<label for="yourPasswordRepeat" class="form-label">Repite tu contraseña</label>
											<div class="input-group has-validation" id="repeatePasswordGroup">
												<span class="input-group-text" id="inputGroupPrepend1">
													<i class="fa-solid fa-key"></i>
												</span>
												<input type="password" name="repeate_password" class="form-control" id="yourPasswordRepeat"
													required />
                        <label class="input-group-text btn btn-outline-secondary" id="btnMostrar2">
                          <input type="checkbox" id="check2" hidden>
                          <i class="fa-solid fa-eye-slash"></i>
                        </label>
												<div class="invalid-feedback">
													La contraseña no coincide!
												</div>
											</div>

										</div>
										<br>
										<!-- Crear usuario root -->
										<div class="col-12">
											<button class="btn btn-primary w-100" type="submit" id="Enviar">
												Crear usuario cliente
											</button>
										</div>
									</form>

								</div>
							</div>

							<div class="credits">
								<!-- All the links in the footer should remain intact. -->
								<!-- You can delete the links only if you purchased the pro version. -->
								<!-- Licensing information: https://bootstrapmade.com/license/ -->
								<!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
								Designed by
								<a href="https://bootstrapmade.com/">BootstrapMade</a>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
	</main>
	<!-- End #main -->

	<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
			class="bi bi-arrow-up-short"></i></a>

	<script src="assets/js/pageRegisterRootScript.js"></script>
	<%@include file="components/scripts.jsp" %>

  <script>

    const btnMostrar1 = document.querySelector("#btnMostrar1");
    const btnMostrar2 = document.querySelector("#btnMostrar2");

    const password = document.querySelector("#yourPassword");
    const passwordRepeat = document.querySelector("#yourPasswordRepeat");

    btnMostrar1.children[0].addEventListener("change", function () {
      if (this.checked) {
        password.type = "text";

        btnMostrar1.children[1].classList.remove("fa-eye-slash")
        btnMostrar1.children[1].classList.add("fa-eye")
      } else {
        password.type = "password";

        btnMostrar1.children[1].classList.remove("fa-eye")
        btnMostrar1.children[1].classList.add("fa-eye-slash")
      }
    })

    btnMostrar2.children[0].addEventListener("change", function () {
      if (this.checked) {
        passwordRepeat.type = "text";

        btnMostrar2.children[1].classList.remove("fa-eye-slash")
        btnMostrar2.children[1].classList.add("fa-eye")
      } else {
        passwordRepeat.type = "password";

        btnMostrar2.children[1].classList.remove("fa-eye")
        btnMostrar2.children[1].classList.add("fa-eye-slash")
      }
    })

  </script>
	
</body>

</html>