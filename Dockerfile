FROM java:8-jre
MAINTAINER Cong Shang <shangcong.nz@gmail.com>

ADD ./target/MyPrice.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/MyPrice.jar"]

EXPOSE 5000