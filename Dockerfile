# ----------------------------
# Stage 1: Build with Maven
# ----------------------------
FROM maven:3.9.3-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the project and skip tests
RUN mvn clean package -DskipTests

# ----------------------------
# Stage 2: Run the app
# ----------------------------
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the built JAR from stage 1
COPY --from=build /app/target/Library_Management-0.0.1-SNAPSHOT.jar ./Library_Management.jar

# Expose the port
EXPOSE 8080

# Run the Spring Boot app
CMD ["java", "-jar", "Library_Management.jar"]
