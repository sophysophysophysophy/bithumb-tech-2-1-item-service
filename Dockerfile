FROM openjdk:8-jdk-alpine
LABEL maintainer="61459@naver.com"
VOLUME /tmp
ARG JAR_FILE=./build/libs/*.jar
ADD ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.data.mongodb.url=mongodb://192.168.0.106/admin","-jar", "/app.jar"]