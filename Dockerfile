# Stage 1: Build
FROM maven:3.9.3-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

# Build the project
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy JAR from build stage
COPY --from=build /app/target/Library_Management-1.0.0.jar ./Library_Management-1.0.0.jar

EXPOSE 8080

CMD ["java", "-jar", "Library_Management-1.0.0.jar"]
