FROM adoptopenjdk:11-jre-hotspot
COPY ./target/pivo_web.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "pivo_web.jar"]