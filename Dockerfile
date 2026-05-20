
FROM openjdk:27-ea-trixie
RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y openssl && \
    apt-get clean
COPY target/demo-1.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]