# internet-of-plants

A service using Clojure & RabbitMQ to write data about plant moisture levels into a timeseries database.

## Installation

Clone this repo.

## Usage without docker

To start the RabbitMQ publisher:
```
lein publisher
```

To start the RabbitMQ subscriber:
```
lein subscriber
```

## Usage with docker
If you've made changes to the clojure application, rebuild the uberjar:
```
lein uberjar
```
This is kind of crappy because we're generating a build artifact on the host machine instead of in the container... ok for now.

Then rebuild the container (eventually, would be nice to publish this so `docker-compose` can be run on a machine without the image built locally)
```
docker build -t internet-of-plants:latest .
```

Then start with `docker-compose`:
```
docker-compose up -d
```
