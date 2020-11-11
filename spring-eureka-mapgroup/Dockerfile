FROM maven:3.6.3-jdk-8 AS build
COPY /src /home/app/src
COPY /pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:8
COPY --from=build /home/app/target/mapgroup-0.0.1-SNAPSHOT.jar /usr/src/myapp/mapgroup-0.0.1-SNAPSHOT.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","/usr/src/myapp/demo.jar"]