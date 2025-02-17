FROM openjdk:21
MAINTAINER email="ashrit@koerber-suppychain.com"
EXPOSE 8080
ADD target/bookapp.jar bookapp.jar
ENTRYPOINT ["java","-jar","bookapp.jar"]