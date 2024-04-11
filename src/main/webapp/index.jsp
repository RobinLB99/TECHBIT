<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Iniciando...</title>
  </head>
  <body>
    <script>
      <%
        request.getSession(false).invalidate();
        System.out.println(request.getSession(false) == null);
      %>
      window.location.href = "/TechBit/Main.html";
    </script>
  </body>
</html>
