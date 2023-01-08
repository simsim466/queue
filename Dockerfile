FROM openjdk:17
ADD ./target/*.jar queue.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "queue.jar"]