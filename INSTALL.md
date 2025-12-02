# Guía de Instalación de TECHBIT

Esta guía te ayudará a instalar y ejecutar el proyecto TECHBIT en tu entorno de desarrollo local.

## 1. Prerrequisitos

Asegúrate de tener instaladas las siguientes herramientas:

-   **Git:** Para clonar el repositorio.
-   **JDK 21:** Java Development Kit, versión 21.
-   **Docker y Docker Compose:** Para ejecutar el servicio de la base de datos.

## 2. Pasos de Instalación

### 2.1. Clonar el Repositorio

Abre tu terminal y clona el repositorio del proyecto:

```bash
git clone https://github.com/tu-usuario/TECHBIT.git
cd TECHBIT
```

*(Reemplaza `https://github.com/tu-usuario/TECHBIT.git` con la URL real del repositorio)*

### 2.2. Iniciar la Base de Datos

El proyecto utiliza MariaDB como base de datos, la cual se gestiona a través de Docker.

1.  Abre una terminal en la raíz del proyecto.
2.  Ejecuta el siguiente comando para iniciar el contenedor de MariaDB en segundo plano:

    ```bash
    docker-compose up -d
    ```

Esto iniciará un servicio de MariaDB en el puerto `3306`. La base de datos se llamará `techbit_db` y la contraseña del usuario `root` será `@RootPasswordSecure123`, según lo configurado en `docker-compose.yml`.

### 2.3. Construir la Aplicación

El proyecto utiliza Maven. Usa el Maven Wrapper (`mvnw`) incluido para compilar y empaquetar la aplicación.

En la raíz del proyecto, ejecuta:

```bash
./mvnw clean install
```

Este comando limpiará compilaciones anteriores, compilará el código y creará un archivo JAR ejecutable (uber-jar) en el directorio `target/`.

## 3. Ejecutar la Aplicación

Una vez que la base de datos esté en funcionamiento y el proyecto se haya compilado, puedes iniciar la aplicación.

Ejecuta el siguiente comando desde la raíz del proyecto:

```bash
java -jar target/TechBit-1.0.0.jar
```

Verás un mensaje en la consola indicando que el servidor se ha iniciado:

```
Servidor Tomcat embebido iniciado en el puerto: 8080
```

## 4. Acceder a la Aplicación

Abre tu navegador web y navega a la siguiente URL para acceder a la aplicación:

**http://localhost:8080/TechBit**
