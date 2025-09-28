# ===== Build =====
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -B -q -DskipTests dependency:go-offline
COPY src ./src
RUN mvn -B -q -DskipTests package

# ===== Runtime =====
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copia del JAR generado
COPY --from=build /app/target/*.jar app.jar

# Port: Render inyecta PORT y Spring debe usar server.port=${PORT:8080}
EXPOSE 8080

# Opcional: límites de memoria en contenedor
ENV JAVA_OPTS="-Xms128m -Xmx256m -XX:MaxRAMPercentage=60"

# Usuario no root (opcional pero recomendable)
RUN useradd -m appuser
USER appuser

CMD ["sh","-c","java $JAVA_OPTS -jar app.jar"]
