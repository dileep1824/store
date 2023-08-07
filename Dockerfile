FROM openjdk:20
ADD ./target/docker-jar.jar docker-jar.jar
ENTRYPOINT ["java","-jar","docker-jar.jar"]