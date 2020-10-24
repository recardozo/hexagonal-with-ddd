
FROM maven:3.6.3-jdk-11-slim AS build
WORKDIR /build

COPY ./ /build

RUN mvn clean package -U

#
# RELEASE image
#
FROM adoptopenjdk/openjdk11:jre-11.0.4_11-alpine AS release

COPY --from=build /build/target/*.jar /service.jar

COPY src/docker/docker-entrypoint.sh /
RUN apk add --no-cache curl && \
    chmod +x /docker-entrypoint.sh
ENTRYPOINT ["/docker-entrypoint.sh"]