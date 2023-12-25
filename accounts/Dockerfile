#Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim
WORKDIR application
ARG JAR_FILE=target/accounts-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} accountms.jar
RUN java -Djarmode=layertools -jar -Dspring.profiles.active=local accountms.jar extract

# the second stage of our build will copy the extracted layers
FROM eclipse-temurin:17.0.5_8-jre-focal
WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
