FROM java:8-jre
MAINTAINER Cong Shang <shangcong.nz@gmail.com>

ADD ./target/MyPrice-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/MyPrice.jar"]

EXPOSE 5000