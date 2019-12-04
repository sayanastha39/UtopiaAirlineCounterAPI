FROM openjdk:12-jdk-alpine
VOLUME /tmp
EXPOSE 8080

MAINTAINER sayana.shrestha@smoothstack.com

ENV SPRING_DATASOURCE_URL="jdbc:mysql://lms.cv2mc6y2qhct.us-east-2.rds.amazonaws.com/UtopiaAirline?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"

ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=teamflash123

COPY target/utopiaAirline-0.0.1-SNAPSHOT.jar .

ENTRYPOINT java -jar utopiaAirline-0.0.1-SNAPSHOT.jar