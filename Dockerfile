# Use official Java image
FROM openjdk:17-jdk-slim

# Set workdir
WORKDIR /app

# Copy Maven wrapper and pom
COPY . .

# Install Maven if needed (optional if using mvn from image)
RUN apt-get update && apt-get install -y maven

# Build the project
RUN mvn clean package -DskipTests

# Expose port
EXPOSE 8080

# Run the JAR
CMD ["java", "-jar", "target/Library_Management-1.0.0.jar"]
