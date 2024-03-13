<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Register root Account</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <%@include file="./components/header.jsp"%>
    </head>

    <body>

        <main>
            <div class="container">

                <section
                    class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
                    <div class="container">
                        <div class="row justify-content-center">
                            <div
                                class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

                                <div class="d-flex justify-content-center py-4">
                                    <a href="index.html"
                                       class="logo d-flex align-items-center w-auto"> <img
                                            src="assets/img/logo.png" alt=""> <span
                                            class="d-none d-lg-block">TechBit</span>
                                    </a>
                                </div>
                                <!-- End Logo -->

                                <div class="card mb-3">

                                    <div class="card-body">

                                        <div class="pt-4 pb-2">
                                            <h5 class="card-title text-center pb-0 fs-4">Create Root
                                                Account</h5>
                                            <p class="text-center small">Register your password to
                                                create account</p>
                                        </div>

                                        <form class="row g-3 needs-validation" method="post"
                                              action="SvCreateRoot" id="form" novalidate>
                                            <div class="col-12">
                                                <div class="invalid-feedback">Please, enter your name!</div>
                                            </div>

                                            <div class="col-12">
                                                <label for="yourUsername" class="form-label">Username</label>
                                                <div class="input-group has-validation">
                                                    <span class="input-group-text" id="inputGroupPrepend">@</span>
                                                    <input type="text" name="nombre_usuario"
                                                           class="form-control" id="yourUsername" value="root"
                                                           required disabled>
                                                    <div class="invalid-feedback">Please choose a
                                                        username.</div>
                                                </div>
                                            </div>

                                            <div class="col-12">
                                                <label for="yourPassword" class="form-label">Password</label>
                                                <input type="password" name="contraseña" class="form-control"
                                                       id="yourPassword" required>
                                                <div class="invalid-feedback">Please enter your
                                                    password!</div>
                                            </div>

                                            <div class="col-12">
                                                <label for="yourPasswordRepeat" class="form-label">Repeat
                                                    your password</label> <input type="password" name="repeate_password"
                                                                             class="form-control" id="yourPasswordRepeat" required>
                                                <div class="invalid-feedback">Please repeat your
                                                    password!</div>
                                            </div>

                                            <div class="col-12">
                                                <div class="form-check">
                                                    <input class="form-check-input" name="terms" type="checkbox"
                                                           value="" id="acceptTerms" required> <label
                                                           class="form-check-label" for="acceptTerms">I agree
                                                        and accept the <a href="#">terms and conditions</a>
                                                    </label>
                                                    <div class="invalid-feedback">You must agree before
                                                        submitting.</div>
                                                </div>
                                            </div>
                                            <div class="col-12">
                                                <button class="btn btn-primary w-100" type="submit"
                                                        id="Enviar">Create Account</button>
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

        <a href="#"
           class="back-to-top d-flex align-items-center justify-content-center"><i
                class="bi bi-arrow-up-short"></i></a>

        <%@include file="./components/scripts.jsp"%>

        <script src="./assets/js/pageRegisterRootScript.js"></script>

    </body>

</html>