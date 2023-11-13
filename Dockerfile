FROM openjdk:17
EXPOSE 8080
ADD target/b2c-ecommerce-docker.jar b2c-ecommerce-docker.jar
ENTRYPOINT ["java","-jar","/b2c-ecommerce-docker.jar"]