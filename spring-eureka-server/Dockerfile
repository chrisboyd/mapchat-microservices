FROM maven:3.6.3-jdk-8 AS build
COPY /spring-eureka-server/src /home/app/arc
COPY /spring-eureka-server/pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:8
COPY --from=build /home/app/target/spring-eureka-server-0.0.1-SNAPSHOT.jar /usr/src/myapp/server.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","/usr/src/myapp/server.jar"]
