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

![Imgur](https://i.imgur.com/Xv7EZNy.png)

#### Ingresar como usuario root

![Imgur](https://i.imgur.com/AfXQW7w.png)

#### Dashboard del usuario root

![Imgur](https://i.imgur.com/W9I5BCy.png)

#### Formulario de registro del Técnico

![Imgur](https://i.imgur.com/oWJvqwR.png)

#### Formulario de registro del usuario final

![Imgur](https://i.imgur.com/euFVCx1.png)

#### Registrar credenciales del usuario final mediante el C.I.

![Imgur](https://i.imgur.com/QCFb24S.png)

#### Inicio de sesión del usuario final

![Imgur](https://i.imgur.com/F1lWKwJ.png)

#### Dashboard del usuario final

![Imgur](https://i.imgur.com/RTiB3lp.png)

## Licencia

Este proyecto está bajo la Licencia especificada en el archivo [LICENSE](LICENSE).