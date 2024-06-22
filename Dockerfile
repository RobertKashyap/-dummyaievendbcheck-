FROM openjdk:21-slim

WORKDIR /app

COPY . .

RUN chmod +x mvnw

RUN ./mvnw clean package

COPY target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]