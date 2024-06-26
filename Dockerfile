# FROM openjdk:21-oracle

# WORKDIR /app

# COPY . .

# RUN chmod +x mvnw

# RUN ./mvnw clean package

# COPY target/*.jar app.jar

# EXPOSE 8080

# CMD ["java", "-jar", "app.jar"]

FROM openjdk:21-oracle

WORKDIR /app

COPY app.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]