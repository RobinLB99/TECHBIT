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
            <!-- Personal -->
            <a class="nav-link collapsed" data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-menu-button-wide"></i><span>Personal</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="components-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="SvGoToEmployesList">
                        <i class="bi bi-circle"></i>
                        <span>Registro</span>
                    </a>
                </li>
                <li>
                    <a href="IngresarEmpleados.jsp">
                        <i class="bi bi-circle"></i>
                        <span>Ingreso</span>
                    </a>
                </li>
                <li>
                    <a href="SvGoToUsuariosColaboradores">
                        <i class="bi bi-circle"></i>
                        <span>Usuarios</span>
                    </a>
                </li>
            </ul>

            <!-- Clientes naturales -->
            <a class="nav-link collapsed" data-bs-target="#components-nav1" data-bs-toggle="collapse" href="#">
                <i class="bi bi-menu-button-wide"></i><span>Cliente Natural</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="components-nav1" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="#">
                        <i class="bi bi-circle"></i>
                        <span>Visualizar clientes</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="bi bi-circle"></i>
                        <span>Registrar cliente</span>
                    </a>
                </li>
            </ul>
        </li><!-- End Components Nav -->
    </ul>

</aside><!-- End Sidebar-->
