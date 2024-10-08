FROM alpine:latest as build
LABEL authors="zaran"

RUN apk update
RUN apk add openjdk17

COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew bootJar --no-daemon

FROM openjdk:17-alpine
EXPOSE 9000
COPY --from=build ./build/libs/*.jar ./app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]