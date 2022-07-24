FROM openjdk:8
EXPOSE 8080
ADD target/WelcomePromptJAR.jar welcome.jar
ENTRYPOINT ["java", "-jar", "/welcome.jar"]