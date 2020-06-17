FROM openjdk:8

# Install maven
RUN apt-get update
RUN apt-get install -y maven

WORKDIR /code

# Prepare by downloading dependencies
ADD pom.xml /code/pom.xml
RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]

# Adding source, compile and package into a fat jar
ADD src /code/src
RUN ["mvn", "clean", "install"]

## multi-stage build to reduce size of container
FROM openjdk:8

WORKDIR /app
COPY --from=0 /code/target/anagramChallenge-jar-with-dependencies.jar .

EXPOSE 4567
CMD ["java", "-jar", "anagramChallenge-jar-with-dependencies.jar"]