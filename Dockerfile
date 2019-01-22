FROM java:8-alpine
RUN mkdir -p /app
WORKDIR /app
COPY target/uberjar/*-standalone.jar .
CMD java -cp internet-of-plants-0.1.0-SNAPSHOT-standalone.jar internet_of_plants.$ROLE