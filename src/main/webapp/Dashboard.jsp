<%@page import="com.robinlb.techbit.model.Usuario"%>
<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@include file="/components/ServicioComprobaciónSesionActiva.jsp" %>
<%
    Usuario usuario = (Usuario) request.getSession().getAttribute("logUser");
    String nameSession = usuario.getNombreUsuario();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p><%=nameSession%></p>
        <form method="post" action="SvLogout">
            <button type="submit">Cerrar sesión</button>
        </form>
    </body>
</html>
