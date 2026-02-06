# ---- Etapa 1: Build ----
FROM eclipse-temurin:17-jdk-jammy AS build
WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# ---- Etapa 2: Runtime ----
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

# Render usa $PORT dinámico
CMD ["sh", "-c", "java -jar app.jar --server.port=$PORT"]
