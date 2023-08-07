FROM openjdk:20
RUN ./mvnw install
ADD ./target/docker-jar.jar docker-jar.jar
ENTRYPOINT ["java","-jar","docker-jar.jar"]
