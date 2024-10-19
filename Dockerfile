# Usa una imagen base de OpenJDK
FROM openjdk:21-jdk

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR generado al contenedor
COPY target/*.jar app.jar

# Expone el puerto en el que la aplicación estará escuchando
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
