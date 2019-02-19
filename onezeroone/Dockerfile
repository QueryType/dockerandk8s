FROM alpine:latest

WORKDIR '/app'

RUN apk --update add openjdk8-jre
ADD com/niranjan/docker/HelloJava.class com/niranjan/docker/HelloJava.class

CMD ["java", "com.niranjan.docker.HelloJava"]
