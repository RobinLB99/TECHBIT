<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab" tabindex="0">
                      
  <hr>

  <!-- Botones de modificacion de entrada de la tabla -->
  <div class="d-flex justify-content-between">
    <div class="actions d-flex flex-row gap-3">
      <a href="SvGoToIngresarUsuario" class="btn btn-primary d-flex flex-row gap-2 align-items-center" title="Registrar usuario">
        <i class="fa-solid fa-user-plus"></i>
      </a>
    </div>
  </div>

  <hr>

  <div class="table-responsive">
    <!-- Table with stripped rows -->
    <table class="table datatable table-hover">

      <thead>
        <tr>
          <th></th>
          <th>
            Nombres
          </th>
          <th>
            Apellidos
          </th>
          <th>Cargo</th>
          <th>Departamento</th>
        </tr>
      </thead>
      <tbody>
        
        <%
          for (Empleado empleado : colaboresSinUsuario) {
        %>
        
        <tr>
          <td class="form-cheack">
            <input class="form-check-input" type="checkbox" value="<%= empleado.getId() %>" name="checkbox" id="flexCheckDefault<%= empleado.getId() %>" style="width: 20px; height: 20px">
          </td>
          <td><%= empleado.getNombres() %></td>
          <td><%= empleado.getApellidos() %></td>
          <td><%= empleado.getCargo() %></td>
          <td><%= empleado.getDepartamento() %></td>
          
        </tr>
        
        <%
          }
        %>
        
      </tbody>
    </table>
    <!-- End Table with stripped rows -->
  </div>

</div>