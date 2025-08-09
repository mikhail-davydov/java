FROM quay.io/keycloak/keycloak:latest as builder

ENV KC_HEALTH_ENABLED=true
ENV KC_METRICS_ENABLED=true
ENV KC_FEATURES=token-exchange
ENV KC_DB=postgres
ENV KC_DB_USERNAME=keycloak
ENV KC_DB_PASSWORD=keycloak
ENV KC_DB_URL=jdbc:postgresql://host.docker.internal:5432/local
ENV KC_TRANSACTION_XA_ENABLED=false
# Install custom providers
#COPY library-keycloak-spi-impl.jar /opt/keycloak/providers/library-keycloak-spi-impl.jar
# Export realm
#COPY realm-export.json /opt/keycloak/data/import/
RUN /opt/keycloak/bin/kc.sh build

FROM quay.io/keycloak/keycloak:latest
COPY --from=builder /opt/keycloak/ /opt/keycloak/

WORKDIR /opt/keycloak
RUN keytool -genkeypair -storepass password -storetype PKCS12 -keyalg RSA -keysize 2048 -dname "CN=server" -alias server -ext "SAN:c=DNS:localhost,IP:127.0.0.1" -keystore conf/server.keystore
# change these values to point to a running postgres instance
ENV KC_HOSTNAME=localhost
ENV KC_HOSTNAME_STRICT=false
ENV KC_HOSTNAME_STRICT_HTTPS=false
ENV KC_DB=postgres
ENV KC_DB_USERNAME=keycloak
ENV KC_DB_PASSWORD=keycloak
ENV KC_DB_SCHEMA=keycloak
ENV KC_DB_URL=jdbc:postgresql://host.docker.internal:5432/local
ENV KEYCLOAK_ADMIN=admin
ENV KEYCLOAK_ADMIN_PASSWORD=admin
ENV JAVA_OPTS_APPEND=" -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 "
EXPOSE 8080
EXPOSE 8443
EXPOSE 5005
ENTRYPOINT ["/opt/keycloak/bin/kc.sh", "start-dev", "--import-realm"]
#ENTRYPOINT ["/opt/keycloak/bin/kc.sh", "start-dev", "--import-realm", "--log-level=DEBUG"]
