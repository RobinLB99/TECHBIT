<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.InputStream"%>
<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">

  <ul class="sidebar-nav" id="sidebar-nav">

    <li class="nav-item">
      <a class="nav-link collapsed" href="SvGoToDashboard">
        <i class="bi bi-grid"></i>
        <span>Dashboard</span>
      </a>
    </li><!-- End Dashboard Nav -->

    <li class="nav-item">

      <%
        JSONArray functions = (JSONArray) request.getSession(false).getAttribute("functions_sidebar");

        for (int i = 0; i < functions.length(); i++) {
          JSONObject funcion = functions.getJSONObject(i);
      %>

      <a class="nav-link collapsed" data-bs-target="#components-nav<%=funcion.getString("group_name")%>" data-bs-toggle="collapse" href="#">
        <div class="d-flex justify-content-center align-items-center" style="width: 25px;">
          <i class="<%= funcion.getString("icon")%>"></i>
        </div>
        <span><%=funcion.getString("group_name")%></span>
        <i class="bi bi-chevron-down ms-auto"></i>
      </a>
      <ul id="components-nav<%=funcion.getString("group_name")%>" class="nav-content collapse " data-bs-parent="#sidebar-nav">

        <%
          JSONArray opciones = funcion.getJSONArray("options");
          for (int e = 0; e < opciones.length(); e++) {
            JSONObject opcion = opciones.getJSONObject(e);
        %>
        <li>
          <a href="<%= opcion.getString("link")%>">
            <i class="bi bi-circle"></i>
            <span><%= opcion.getString("name")%></span>
          </a>
        </li>
        <%
          }
        %>
      </ul>
      <%
        }
      %>
    </li>
    <!-- End Components Nav -->
  </ul>

</aside><!-- End Sidebar-->
