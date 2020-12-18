FROM armv7/armhf-java8
COPY build/libs/springboot-docker-raspberrypi-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/data/app.jar"]