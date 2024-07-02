<%@page import="com.robinlb.techbit.model.Empleado"%>
<%@page import="com.robinlb.techbit.controllers.DateController"%>
<%@page import="com.robinlb.techbit.model.TicketSoporte"%>
<%@page import="java.util.List"%>
<%@page import="com.robinlb.techbit.model.Usuario"%>
<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab" tabindex="0">

    <hr>

    <!-- Botones de modificación de entrada de la tabla -->
    <div class="d-flex justify-content-between">
        <div class="actions d-flex flex-row gap-3">

            <!-- Botón para asignar tecnico -->
            <form action="#" method="post" id="asignTicketMethod">
                <input type="hidden" name="TicketID_" id="ticketIDSelected" />
                <button type="submit" class="btn btn-primary d-flex flex-row gap-2 align-items-center" id="btnAsignTech" title="Asignar tecnico al ticket" data-bs-toggle="modal" data-bs-target="#confirmarAsignacion" disabled>
                    <i class="fa-solid fa-user-gear"></i>
                </button>
            </form>
        </div>

        <!-- Botones de marcación de entrada y refresco -->
        <div class="actions d-flex flex-row gap-3">
            <a href="SvGoToNoAsigmentTickets" class="btn btn-success d-flex flex-row gap-2 align-items-center" title="Actualizar tabla">
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
                    <th>Tituto</th>
                    <th>Categoria</th>
                    <th>Fecha de creación</th>
                    <th>Usuario final</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>

                <%
                    List<TicketSoporte> tna = (List<TicketSoporte>) request.getSession(false).getAttribute("TicketsNoAsignados");

                    DateController dateControl = new DateController();

                    for (TicketSoporte ticket : tna) {
                %>

                <tr>
                    <td>
                        <input type="radio" name="_idTicket" class="form-check-input" value="<%= ticket.getTicketId()%>" style="width: 25px; height: 25px;">
                    </td>
                    <td><%= ticket.getTitulo()%></td>
                    <td><%= ticket.getCategoria()%></td>
                    <td><%= dateControl.dateToStringForView(ticket.getCreacion())%></td>
                    <td><%= ticket.getClienteNatural().getNombres()%> <%= ticket.getClienteNatural().getApellidos()%></td>
                    <td class="">
                        <div class="btn btn-primary" name="detail" title="Detalle" data-bs-toggle="modal" data-bs-target="#exampleModal">
                            <i class="fa-solid fa-circle-info"></i>
                            <input type="hidden" name="title" value="<%= ticket.getTitulo()%>">
                            <input type="hidden" name="category" value="<%= ticket.getCategoria()%>">
                            <input type="hidden" name="creation" value="<%= dateControl.dateToStringForView(ticket.getCreacion())%>">
                            <input type="hidden" name="autor" value="<%= ticket.getClienteNatural().getNombres()%> <%= ticket.getClienteNatural().getApellidos()%>">
                            <input type="hidden" name="descrciption" value="<%= ticket.getDescripcion()%>">
                        </div>
                    </td>
                </tr>

                <%
                    }
                %>

            </tbody>
        </table>
        <!-- End Table with stripped rows -->
    </div>

</div>


<!-- Modal de visualización de detalles -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Más detalles</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="d-flex flex-column">
                    <div class="d-flex flex-column align-items-end" style="font-size: 12px;">
                        <span id="creacion"></span>
                        <span id="autor"></span>
                    </div>
                    <span id="categoryt"></span>
                    <span id="title" class="mt-0 h4"></span>
                </div>
                <div id="detallest" style="font-size: 13px;"></div>
            </div>
        </div>
    </div>
</div>

<!-- Modal de confirmación de asignación -->
<div class="modal fade" id="confirmarAsignacion" tabindex="-1" aria-labelledby="confirmarAsignacionLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="confirmarAsignacionLabel">Asignar ticket</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p>¿Selecciona el técnico al que asignarle el ticket?</p>
                <table class="table datatable table-hover">
                    <thead>
                        <tr>
                            <th></th>
                            <th>Nombres</th>
                            <th>Apellidos</th>
                            <th>Cargo</th>
                            <th>Departamento</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<Empleado> tecnicosSoporte1 = (List<Empleado>) request.getSession(false).getAttribute("tecnicosSoporte1");

                            for (Empleado tecnicoSoporte1 : tecnicosSoporte1) {
                        %>
                        <tr>
                            <td>
                                <input class="form-check-input" type="radio" 
                                       name="id_tecnico_lista" 
                                       value="<%= tecnicoSoporte1.getId()%>"
                                       style="width: 25px; height: 25px;" />
                            </td>
                            <td><%= tecnicoSoporte1.getNombres()%></td>
                            <td><%= tecnicoSoporte1.getApellidos()%></td>
                            <td><%= tecnicoSoporte1.getCargo() %></td>
                            <td><%= tecnicoSoporte1.getDepartamento() %></td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" id="btnasign">Continuar</button>
            </div>
        </div>
    </div>
</div>