# springboot-docker-raspberrypi

This repository contains a hello world spring boot applicaiton with a docker file that helps running it on rasbery pi.

### Building a docker image with the application

Just run:

```
./gradlew clean build
docker build -t zlate87/springboot-docker-raspberrypi .
docker push zlate87/springboot-docker-raspberrypi
```

### Running a docker container on the Raspberry Pi

Just run:

```
docker run -p80:8080 zlate87/springboot-docker-raspberrypi
```
