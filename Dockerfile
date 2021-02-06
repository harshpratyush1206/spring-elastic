FROM openjdk:8 as build
MAINTAINER Harsh Pratyush
ADD . .
CMD ./gradlew build

FROM openjdk:8-jdk-alpine
RUN addgroup -S seacrh-user && adduser -S seacrh-user -G seacrh-user
USER seacrh-user:seacrh-user

ARG JAR_FILE=build/libs/*.jar
COPY --from=build ${JAR_FILE} search-service.jar

ENTRYPOINT ["java", "-jar", "search-service.jar"]