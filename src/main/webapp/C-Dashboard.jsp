<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="components/head.jsp" %>
    <title>Dashboard - Cliente / TechBit</title>
  </head>
  <body>
    <%
      Usuario usuario = (Usuario) request.getSession(false).getAttribute("user");
    %>
    <%@include file="components/header-cliente.jsp" %>
    <%@include file="components/Sidebar.jsp" %>

    <div class="pagetitle">
      <h1>Dashboard</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="C-Dashboard.jsp">Home</a></li>
          <li class="breadcrumb-item active">Dashboard</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <%@include file="components/scripts.jsp" %>
  </body>
</html>