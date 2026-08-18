FROM eclipse-temurin:25-jre-jammy
RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y openssl && \
    apt-get clean
COPY target/demo-1.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]