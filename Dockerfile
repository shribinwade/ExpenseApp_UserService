FROM amazoncorretto:21

LABEL maintainer="shrihari"

WORKDIR /app

COPY build/libs/userservice.jar /app/userservice.jar

ENTRYPOINT ["java", "-jar", "/app/userservice.jar"]