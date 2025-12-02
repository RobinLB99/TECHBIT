# TECHBIT - Sistema de Gestión de Tickets de Soporte

TECHBIT es una aplicación web diseñada para la gestión de tickets de soporte técnico. Permite a los clientes crear tickets, y al personal de soporte asignarlos, gestionarlos y resolverlos de manera eficiente.

## Características Principales

- **Gestión de Usuarios:** Roles para administradores, colaboradores (personal de soporte) y clientes finales.
- **Creación de Tickets:** Los clientes pueden crear nuevos tickets de soporte detallando sus problemas.
- **Asignación de Tickets:** Los administradores o supervisores pueden asignar tickets no asignados a los técnicos disponibles.
- **Seguimiento de Tickets:** Visualización y seguimiento del estado de los tickets (abierto, en progreso, cerrado).
- **Dashboard:** Paneles informativos con estadísticas relevantes sobre los tickets y el rendimiento del equipo.

## Tecnologías Utilizadas

- **Backend:**
  - Java 21
  - Jakarta EE 10
  - JPA (EclipseLink) para la persistencia de datos.
  - Servidor web Tomcat 10.1 embebido.
- **Base de Datos:**
  - MariaDB (gestionada con Docker).
- **Frontend:**
  - JavaServer Pages (JSP)
  - HTML, CSS y JavaScript.
  - Bootstrap para el diseño responsivo.
- **Build Tool:**
  - Apache Maven.

## Cómo Empezar

Para obtener instrucciones detalladas sobre cómo clonar, configurar y ejecutar el proyecto en tu máquina local, por favor consulta la [**Guía de Instalación (INSTALL.md)**](INSTALL.md).

## Demo

#### Creación del Usuario root

![](/home/joel/snap/marktext/9/.config/marktext/images/2025-12-02-16-54-05-Captura%20de%20pantalla%20de%202025-12-02%2016-45-54.png)

#### Ingresar como usuario root

![](/home/joel/snap/marktext/9/.config/marktext/images/2025-12-02-16-54-14-Captura%20de%20pantalla%20de%202025-12-02%2016-46-18.png)

#### Dashboard del usuario root

![](/home/joel/snap/marktext/9/.config/marktext/images/2025-12-02-16-54-22-Captura%20de%20pantalla%20de%202025-12-02%2016-46-39.png)

#### Formulario de registro del Técnico

![](/home/joel/snap/marktext/9/.config/marktext/images/2025-12-02-16-54-36-Captura%20de%20pantalla%20de%202025-12-02%2016-46-56.png)

#### Formulario de registro del usuario final

![](/home/joel/snap/marktext/9/.config/marktext/images/2025-12-02-16-54-43-Captura%20de%20pantalla%20de%202025-12-02%2016-47-18.png)

#### Listado de usuarios finales

![](/home/joel/snap/marktext/9/.config/marktext/images/2025-12-02-16-55-05-Captura%20de%20pantalla%20de%202025-12-02%2016-49-28.png)

#### Registrar credenciales del usuario final mediante el C.I.

![](/home/joel/snap/marktext/9/.config/marktext/images/2025-12-02-16-55-11-Captura%20de%20pantalla%20de%202025-12-02%2016-50-20.png)

#### Inicio de sesión del usuario final

![](/home/joel/snap/marktext/9/.config/marktext/images/2025-12-02-16-55-17-Captura%20de%20pantalla%20de%202025-12-02%2016-50-38.png)

#### Dashboard del usuario final

![](/home/joel/snap/marktext/9/.config/marktext/images/2025-12-02-16-55-22-Captura%20de%20pantalla%20de%202025-12-02%2016-50-49.png)

## Licencia

Este proyecto está bajo la Licencia especificada en el archivo [LICENSE](LICENSE).