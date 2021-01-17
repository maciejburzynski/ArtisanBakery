# the first stage of our build will use a maven 3.6.1 parent image
FROM maven:3.6.3-jdk-11 AS MAVEN_BUILD

# copy the pom and src code to the container
COPY ./ ./

# package our application code
RUN mvn clean package

FROM openjdk:11-jre-slim

# copy only the artifacts we need from the first stage and discard the rest
COPY --from=MAVEN_BUILD /target/bakery-0.0.1-SNAPSHOT.jar /bakery.jar

# set the startup command to execute the jar
CMD ["java", "-jar", "/bakery.jar"]


# command to build an image:
# docker build -f Dockerfile -t springdocker:v1 .

# command to run the container:
# docker run -p 8080:8080 <image id>