# Instrucciones para Ejecutar el Proyecto en Docker

A continuación se detallan los pasos para ejecutar el proyecto en un contenedor Docker.

## Requisitos Previos

Asegúrate de tener instalados los siguientes programas en tu sistema:

- **Git**: [Instrucciones de instalación](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
- **Maven**: [Instrucciones de instalación](https://maven.apache.org/install.html)
- **Java 21 OpenJDK**: [Descargar JDK](https://adoptium.net/es/)
- **Docker**: [Instrucciones de instalación](https://docs.docker.com/get-docker/)

## Pasos para Clonar y Ejecutar el Proyecto

1. **Clona el repositorio**:
   ```bash
   git clone https://github.com/PedroOsorioCode/userapi.git
   ```
2. **Abrir consola CMD e Ir a la carpeta donde se clonó el repositorio**:
   ```bash
   cd to_directorio
   ```
3. **Ejecutar**:
   ```bash
   mvn clean install
   ```
4. **Construir imagen de docker**:
   ```bash
   docker build -t userapi .
   ```
4. **Ejecutar contenedor**:
   ```bash
   docker run -p 8080:8080 userapi
   ```
5. **Acceder a las url**:
 - [Swagger](http://localhost:8080/swagger-ui/index.html#/usuario-controller/registrarUsuario)
 - [H2-database](http://localhost:8080/h2-console)

### Ejemplos
- ![](doc/1_Ejecucion_Postman.png)
- ![](doc/2_Validacion_JWT.png)
- ![](doc/3_bd_from_docker.png)
- ![](doc/3_Base_de_datos.png)
- ![](doc/5_Cobertura_de_codigo.png)
- ![](doc/6_ejecutar_docker.png)
- ![](doc/7_ver_docker_deploy.png)

### Validaciones
- ![](doc/4_validacion_email_invalido.png)
- ![](doc/4_validaciones_email_existe.png)
- ![](doc/4_validaciones_password_invalido.png)