FROM adoptopenjdk/openjdk11:alpine-jre
COPY target/spring-postgresql.jar spring-postgresql.jar
ENTRYPOINT ["java","-jar","spring-postgresql.jar"]