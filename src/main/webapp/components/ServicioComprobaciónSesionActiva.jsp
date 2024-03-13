<%@page import="com.robinlb.techbit.model.Usuario"%>
<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%--
    * Comprueba si existe una sesión activa y redirige según la pagina a actual.
--%>
<%
    String log = (String) request.getSession().getAttribute("session");
    String currentURL = request.getRequestURI();

    if (log.equals("logon") && currentURL.equals("/TechBit/Login.jsp")) {
        response.sendRedirect("Dashboard.jsp");
        
    } else if (!currentURL.equals("/TechBit/Login.jsp") && log.equals("logoff")) {
        response.sendRedirect("Login.jsp");
    }
%>