# Guía de Instalación y Ejecución de TECHBIT

Esta guía te ayudará a instalar y ejecutar el proyecto TECHBIT en tu entorno de desarrollo local utilizando Docker Compose.

## 1. Prerrequisitos

Asegúrate de tener instaladas las siguientes herramientas:

-   **Git:** Para clonar el repositorio.
-   **Docker y Docker Compose:** Para construir y ejecutar la aplicación y su base de datos.
-   **JDK 21 (Opcional):** Solo si necesitas construir la aplicación manualmente o ejecutar pruebas fuera del contenedor Docker. La imagen Docker ya incluye un JDK.

## 2. Pasos de Instalación y Ejecución

### 2.1. Clonar el Repositorio

Abre tu terminal y clona el repositorio del proyecto:

```bash
git clone https://github.com/tu-usuario/TECHBIT.git
cd TECHBIT
```

*(Reemplaza `https://github.com/tu-usuario/TECHBIT.git` con la URL real del repositorio)*

### 2.2. Configurar Variables de Entorno

El proyecto utiliza variables de entorno para la configuración de la base de datos.

1.  Copia el archivo de ejemplo `.env.example` a un nuevo archivo llamado `.env` en la raíz del proyecto:

    ```bash
    cp .env.example .env
    ```

2.  Edita el archivo `.env` y configura los valores según sea necesario para tu entorno (puedes mantener los valores por defecto si no tienes requisitos específicos).

    ```
    DB_HOST=mariadb
    DB_PORT=3306
    DB_USER=root
    DB_PASSWORD=@RootPasswordSecure123
    DB_NAME=techbit_db
    ```

### 2.3. Iniciar la Aplicación con Docker Compose

Docker Compose se encargará de construir la imagen de la aplicación, iniciar el servicio de la base de datos (MariaDB) y desplegar la aplicación en un servidor Tomcat.

En la raíz del proyecto, ejecuta el siguiente comando:

```bash
docker-compose up --build
```

Este comando realizará las siguientes acciones:
-   Leerá el archivo `.env` para cargar las variables de entorno.
-   Construirá la imagen Docker de la aplicación Java, compilando el código y generando el WAR.
-   Creará e iniciará un contenedor para la base de datos MariaDB.
-   Creará e iniciará un contenedor para la aplicación Tomcat con tu WAR desplegado.

Verás los logs de ambos servicios en tu terminal. Esto puede tardar unos minutos la primera vez.

## 3. Acceder a la Aplicación

Una vez que Docker Compose haya terminado de iniciar los servicios, la aplicación estará disponible.

Abre tu navegador web y navega a la siguiente URL para acceder a la aplicación:

**http://localhost:8080/**

Si necesitas detener los servicios, puedes hacerlo con `docker-compose down`. Si además deseas eliminar los volúmenes de datos persistentes de la base de datos (por ejemplo, para empezar con una base de datos limpia), usa `docker-compose down -v`. Puedes ejecutar estos comandos en la misma terminal donde ejecutaste `docker-compose up` (o en una nueva terminal si lo ejecutaste con `-d`).
