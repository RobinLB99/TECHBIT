<%@page contentType="text/html" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">

  <head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Login - TechBit</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <%@include file="components/head.jsp" %>
  </head>

  <body>

    <main>
      <div class="container">

        <section
          class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
          <div class="container">
            <div class="row justify-content-center">
              <div class="col-lg-9 col-md-9 d-flex flex-column align-items-center justify-content-center">

                <div class="d-flex justify-content-center py-4">
                  <a href="index.html" class="logo d-flex align-items-center w-auto">
                    <img src="assets/img/logo.png" alt="">
                    <span class="d-none d-lg-block">TechBit</span>
                  </a>
                </div>
                <!-- End Logo -->

                <div class="card mb-3">

                  <div class="card-body">

                    <div class="pt-4 pb-2">
                      <h5 class="card-title text-center pb-0 fs-4">Registrar cuenta cliente
                      </h5>
                      <p class="text-center small">
                        Para registrar su cuenta, debe tener una licencia activa ligada a su número de identidad registrado en la compra de esta.
                      </p>
                    </div>

                    <form id="createClientAccount" class="row g-3 needs-validation" method="post" action="SvRegistrarCuentaCliente"
                          novalidate>

                          <div class="col-6">
                            <label for="yourNUI" class="form-label">NUI</label>
                            <div class="input-group has-validation">
                              <input type="text" name="numero_identidad" class="form-control"
                                     id="yourNUI" required>
                              <div class="invalid-feedback">
                                Por favor, ingrese su numero de identificación!
                              </div>
                            </div>
                          </div>

                      <div class="col-6">
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
                          <label class="btn btn-outline-secondary" id="buttonViewPassword">
                            <input type="checkbox" name="" id="checkViewPassword" hidden>
                            <i class="fa-solid fa-eye-slash"></i>
                          </label>
                          <div class="invalid-feedback">Please enter your password!</div>
                        </div>

                      </div>

                      <div class="col-12">
                        <label for="repeateYourPassword" class="form-label">Repetir la contraseña</label>
                        <div class="input-group has-validation">
                          <span class="input-group-text" id="inputGroupPrepend">
                            <i class="fa-solid fa-key"></i>
                          </span>
                          <input type="password" name="repetir_contraseña" class="form-control"
                                 id="repeateYourPassword" required>
                          <label class="btn btn-outline-secondary" id="buttonViewPassword2">
                            <input type="checkbox" name="" id="checkViewPassword" hidden>
                            <i class="fa-solid fa-eye-slash"></i>
                          </label>
                          <div class="invalid-feedback">La contraseña no coincide con la del campo anterior.</div>
                        </div>

                      </div>

                      <br/>

                      <div class="col-12">
                        <button class="btn btn-primary w-100" type="submit">Crear cuenta</button>
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

    <%@include file="components/scripts.jsp" %>
    <script>

      document.addEventListener("DOMContentLoaded", function () {
        const inputPassword = document.querySelector("#yourPassword");
        const inputRepeatePassword = document.querySelector('#repeateYourPassword');
        const buttonViewPassword = document.querySelector("#buttonViewPassword");
        const buttonViewPassword2 = document.querySelector("#buttonViewPassword2");

        document.querySelector("#createClientAccount")
        .addEventListener("submit", function (event) {
          event.preventDefault();
          
          if (inputRepeatePassword.value === inputPassword.value) {
            inputRepeatePassword.classList.remove("is-invalid");
            this.submit();
          } else {
            inputRepeatePassword.classList.remove("is-valid");
            inputRepeatePassword.classList.add("is-invalid");
            inputRepeatePassword.focus();
          }

        })

        inputRepeatePassword.addEventListener("input", function () {
          if (inputRepeatePassword.value !== inputPassword.value) {
            inputRepeatePassword.classList.add("is-invalid");
          } else {
            inputRepeatePassword.classList.remove("is-invalid");
            inputRepeatePassword.classList.add("is-valid");
          }
        })

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

        buttonViewPassword2.children[0].addEventListener("change", function () {
          if (this.checked) {
            inputRepeatePassword.type = "text"
            buttonViewPassword2.children[1].classList.remove("fa-eye-slash")
            buttonViewPassword2.children[1].classList.add("fa-eye")
          } else {
            inputRepeatePassword.type = "password"
            buttonViewPassword2.children[1].classList.remove("fa-eye")
            buttonViewPassword2.children[1].classList.add("fa-eye-slash")
          }
        })

      });

    </script>
    
  </body>

</html>