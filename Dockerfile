FROM clojure:latest
RUN mkdir -p /app
WORKDIR /app
COPY project.clj .
COPY src .
RUN lein uberjar
CMD java -cp target/uberjar/internet-of-plants-0.1.0-SNAPSHOT-standalone.jar internet_of_plants.$ROLE