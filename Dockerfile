# Usar una imagen base de OpenJDK 21
FROM openjdk:21-jdk

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR generado en el contenedor
COPY target/productos-0.0.1-SNAPSHOT.jar /app/productos.jar

# Copiar el script wait-for-it.sh
COPY wait-for-it.sh /app/wait-for-it.sh
RUN chmod +x /app/wait-for-it.sh

# Exponer el puerto en el que la aplicación se ejecutará
EXPOSE 83

# Comando para ejecutar la aplicación
ENTRYPOINT ["./wait-for-it.sh", "db:3306", "--", "java", "-jar", "productos.jar"]