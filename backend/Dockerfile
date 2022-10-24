FROM openjdk:17-jdk-slim AS builder
RUN ["pwd"]
#COPY /home/ubuntu/application.yml src/main/resources/application.yml
#ENV jasyptKey cat ../../jasyptKey
RUN echo ${JASYPT_KEY}
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew build --exclude-task test

#FROM adoptopenjdk:11-jdk-hotspot
#COPY --from=builder build/libs/*.jar app.jar
FROM openjdk:17-jdk-slim
COPY --from=builder build/libs/Moogle-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/app.jar" , "-Djasypt.encryptor.password=${JASYPT_KEY}" ]