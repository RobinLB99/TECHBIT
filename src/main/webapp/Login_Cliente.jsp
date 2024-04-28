<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

  <head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Login - TechBit</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Favicons -->
    <link href="assets/img/favicon.png" rel="icon">
    <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect">
    <link
      href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
      rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link type="text/css" href="./assets/vendor/bootstrap/css/bootstrap.min.css"
          rel="stylesheet">
    <link type="text/css" href="./assets/vendor/bootstrap-icons/bootstrap-icons.css"
          rel="stylesheet">
    <!--    <link type="text/css" href="./assets/vendor/boxicons/css/boxicons.min.css"
              rel="stylesheet">
        <link type="text/css" href="./assets/vendor/quill/quill.snow.css" rel="stylesheet">
        <link type="text/css" href="./assets/vendor/quill/quill.bubble.css" rel="stylesheet">
        <link type="text/css" href="./assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link type="text/css" href="./assets/vendor/simple-datatables/style.css" rel="stylesheet">-->

    <!-- WebFonts for Fontsawesome -->
    <link type="font/ttf" href="./assets/webfonts/fa-brands-400.ttf">
    <link type="font/ttf" href="./assets/webfonts/fa-regular-400.ttf">
    <link type="font/ttf" href="./assets/webfonts/fa-solid-900.ttf">
    <link type="font/ttf" href="./assets/webfonts/fa-v4compatibility.ttf">

    <!-- Fontsawesome -->
    <link type="text/css" href="./assets/css/all.css" rel="stylesheet">
    <link type="text/css" href="./assets/css/fontawesome.css" rel="stylesheet">
    <link type="text/css" href="./assets/css/v5-font-face.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link type="text/css" href="./assets/css/style.css" rel="stylesheet">
  </head>

  <body>

    <main>
      <div class="container">

        <section
          class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
          <div class="container">
            <div class="row justify-content-center">
              <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

                <div class="d-flex justify-content-center py-4">
                  <a href="index.html" class="logo d-flex align-items-center w-auto">
                    <!-- <img src="assets/img/logo.png" alt=""> -->
                    <span class="d-none d-lg-block">TechBit</span>
                  </a>
                </div>
                <!-- End Logo -->

                <div class="card mb-3">

                  <div class="card-body">

                    <div class="pt-4 pb-2">
                      <h5 class="card-title text-center pb-0 fs-4">Inicia sesión con tu cuenta
                      </h5>
                      <p class="text-center small">Ingresa tu usuario y contraseña para iniciar
                        sesión.</p>
                    </div>

                    <form class="row g-3 needs-validation" method="post" action="SvLoginCliente"
                          novalidate>

                      <div class="col-12">
                        <label for="yourUsername" class="form-label">Usuario</label>
                        <div class="input-group has-validation">
                          <span class="input-group-text" id="inputGroupPrepend">
                            <i class="fa-solid fa-at"></i>
                          </span>
                          <input type="text" name="nombre_usuario" class="form-control"
                                 id="yourUsername" required>
                          <div class="invalid-feedback">Please enter your
                            username.</div>
                        </div>
                      </div>

                      <div class="col-12">
                        <label for="yourPassword" class="form-label">Contraseña</label>
                        <div class="input-group has-validation">
                          <span class="input-group-text" id="inputGroupPrepend">
                            <i class="fa-solid fa-key"></i>
                          </span>
                          <input type="password" name="contraseña" class="form-control"
                                 id="yourPassword" required>
                          <div class="invalid-feedback">Please enter your password!</div>
                          <label class="btn btn-outline-secondary" id="buttonViewPassword">
                            <input type="checkbox" name="" id="checkViewPassword" hidden>
                            <i class="fa-solid fa-eye-slash"></i>
                          </label>
                        </div>

                      </div>

                      <div class="col-12">
                        <span class="d-flex justify-content-center" style="width: 100%;">
                          <a href="CreateClientAccount.html">
                            Crear una cuenta
                          </a>
                        </span>
                      </div>

                      <div class="col-12">
                        <button class="btn btn-primary w-100" type="submit">Login</button>
                      </div>
                    </form>

                  </div>
                </div>

                <div class="credits">
                  <!-- All the links in the footer should remain intact. -->
                  <!-- You can delete the links only if you purchased the pro version. -->
                  <!-- Licensing information: https://bootstrapmade.com/license/ -->
                  <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
                  Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
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

    <!-- Vendor JS Files -->
    <script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
    <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!--    <script src="assets/vendor/chart.js/chart.umd.js"></script>
    <script src="assets/vendor/echarts/echarts.min.js"></script>
    <script src="assets/vendor/quill/quill.min.js"></script>
    <script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
    <script src="assets/vendor/tinymce/tinymce.min.js"></script>
    <script src="assets/vendor/php-email-form/validate.js"></script>-->

    <!-- Template Main JS File -->
    <script src="assets/js/main.js"></script>

    <script>

      document.addEventListener("DOMContentLoaded", function () {
        const inputPassword = document.querySelector("#yourPassword");
        const buttonViewPassword = document.querySelector("#buttonViewPassword");

        buttonViewPassword.children[0].addEventListener("change", function () {
          if (this.checked) {
            inputPassword.type = "text"
            buttonViewPassword.children[1].classList.remove("fa-eye-slash")
            buttonViewPassword.children[1].classList.add("fa-eye")
          } else {
            inputPassword.type = "password"
            buttonViewPassword.children[1].classList.remove("fa-eye")
            buttonViewPassword.children[1].classList.add("fa-eye-slash")
          }
        })

      });

    </script>
  </body>

</html>