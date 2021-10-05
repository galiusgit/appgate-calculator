FROM openjdk:11.0-jdk-slim-stretch

RUN apt-get install -y tzdata
RUN apt-get update
RUN apt-get install -qq -y curl

ENV TZ America/Bogota

VOLUME [ "/home" ]

ENTRYPOINT [ "java", "-jar", "-Dlogging.level.web=debug", "-Dlog4j.debug=true", "-Dlog4j.configurationFile=file:/home/appgate-calculator/target/classes/log4j2.xml", "-DlogFileLocation=/home/appgate-calculator/target/classes/logs", "-Djava.security.egd=file:/dev/./urandom ", "/home/appgate-calculator/target/launcher-1.0.0.jar" ]

