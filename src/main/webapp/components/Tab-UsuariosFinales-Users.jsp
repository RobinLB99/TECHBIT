<%@page import="java.util.List"%>
<%@page import="com.robinlb.techbit.model.Usuario"%>
<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab" tabindex="0">

  <hr>

  <!-- Botones de modificación de entrada de la tabla -->
  <div class="d-flex justify-content-between">
    <div class="actions d-flex flex-row gap-3">
      
      <!-- Botón para restablecer contraseña -->
      <form action="#" method="get" id="ResetPasswordBtn" hidden>
        <input type="text" name="idForResetPassword" id="idForResetPassword" hidden>
        <button type="submit" class="btn btn-secondary d-flex flex-row gap-2 align-items-center" id="btnResetPassword" title="Restablecer contraseña" disabled>
          <i class="fa-solid fa-key"></i>
        </button>
      </form>

      <!-- Botón para modificar usuario -->
      <form action="#" method="get" id="ModifyUserBtn" hidden>
        <input type="text" name="inIdEmMod" id="inIdEmMod" hidden>
        <button type="submit" class="btn btn-secondary d-flex flex-row gap-2 align-items-center" id="btnActualizarRegistro" title="Actualizar registro" disabled>
          <i class="fa-solid fa-user-pen"></i>
        </button>
      </form>
    </div>

    <!-- Botones de marcación de entrada y refresco -->
    <div class="actions d-flex flex-row gap-3">
      <a href="SvGoToCredencialesUsuariosFinales" class="btn btn-success d-flex flex-row gap-2 align-items-center" title="Actualizar tabla">
        <i class="fa-solid fa-rotate-right"></i>
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
          <th>Usuario</th>
          <th>Acceso</th>
          <th>Propietario</th>
        </tr>
      </thead>
      <tbody>

        <%
          List<Usuario> cuf = (List<Usuario>) request.getSession(false).getAttribute("usuarios_usuariosFinales");
          
          for (Usuario user : cuf) {
        %>
        
        <tr>
          <td class="form-cheack">
            <input class="form-check-input" type="radio" value="<%= user.getUsuarioId() %>" name="checkboxUser" id="flexCheckDefault<%= user.getUsuarioId() %>" style="width: 20px; height: 20px">
          </td>
          <td><%= user.getNombreUsuario() %></td>
          <td><%= user.getPrivilegios() %></td>
          <td><%= user.getClienteNatural().getNombres().concat(" " + user.getClienteNatural().getApellidos()) %></td>
        </tr>
        
        <%
          }
        %>
        
      </tbody>
    </table>
    <!-- End Table with stripped rows -->
  </div>

</div>