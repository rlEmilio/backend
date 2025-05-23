# Etapa 1: Construcción
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copia el jar desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto (Render usará la variable PORT automáticamente)
EXPOSE 8080

# Usa el puerto que Render define en la variable de entorno PORT
ENV PORT 8080
ENV JAVA_OPTS="-Dserver.port=${PORT}"

# Ejecuta el jar
CMD ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
