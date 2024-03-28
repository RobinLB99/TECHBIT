<%@page import="com.robinlb.techbit.model.Usuario"%>
<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@include file="/components/ServicioComprobaciónSesionActiva.jsp" %>
<%  Usuario usuario = (Usuario) request.getSession().getAttribute("logUser");
    String username = (usuario.getNombreUsuario().equals("root"))
            ? "Administrador"
            : usuario.getNombreUsuario();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleados</title>
        <meta content="" name="description">
        <meta content="" name="keywords">
        <%@include file="/components/head.jsp" %>
    </head>
    <body>
        <%@include file="/components/header.jsp" %>
        <%@include file="/components/Sidebar.jsp" %>
        <main id="main" class="main">
            <div class="pagetitle">
                <h1>Dashboard</h1>
                <nav>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="SvGoToDashboard">Home</a></li>
                        <li class="breadcrumb-item"><a href="#">Empleados</a></li>
                        <li class="breadcrumb-item active">Lista de empleados</li>
                    </ol>
                </nav>
            </div><!-- End Page Title -->

        </main>
        <%@include file="/components/Footer.jsp" %>

        <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

        <%@include file="/components/scripts.jsp" %>
    </body>
</html>
