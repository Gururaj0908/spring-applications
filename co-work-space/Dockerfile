
FROM openjdk:17
EXPOSE 8080
ADD /build/libs/payfacBackend-0.0.1-SNAPSHOT.jar payfacBackend-0.0.1-SNAPSHOT.jar

# Define environment variables
ENV DATABASE_HOST=172.17.0.2
ENV DATABASE_NAME=payfac
ENV DATABASE_PORT=5432
ENV PASSWORD=password

ENTRYPOINT ["java", "-jar", "/payfacBackend-0.0.1-SNAPSHOT.jar"]