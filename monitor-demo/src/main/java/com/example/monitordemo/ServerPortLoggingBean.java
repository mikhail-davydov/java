package com.example.monitordemo;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

@Slf4j
@Component
public class ServerPortLoggingBean {

    @Value("${server.port:8080}")
    private int serverPort;

    private final Environment environment;
    private final WebEndpointProperties webEndpointProperties;

    public ServerPortLoggingBean(
            Environment environment,
            WebEndpointProperties webEndpointProperties
    ) {
        this.environment = environment;
        this.webEndpointProperties = webEndpointProperties;
    }

    @PostConstruct
    public void logServerInfo() {
        String[] activeProfiles = environment.getActiveProfiles();
        String host = "unknown";
        try {
            host = activeProfiles.length > 0 && "local".equals(activeProfiles[0]) ? "localhost" : InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ignored) {
            // ignored
        }

        String basePath = environment.getProperty("server.base-path", "");
        String actuatorPath = basePath + webEndpointProperties.getBasePath();
        String baseUrl = String.format("http://%s:%d", host, serverPort);
        String separator = "---------------------";

        log.info("");
        log.info(separator);
        log.info("Application started at: {}", LocalDateTime.now());
        log.info(baseUrl);
        log.info("");
        log.info("{}", baseUrl + actuatorPath + "/health");
        log.info("{}", baseUrl + actuatorPath + "/info");
        log.info("{}", baseUrl + actuatorPath + "/metrics");
        log.info("{}", baseUrl + actuatorPath + "/prometheus");
        log.info(separator);
        log.info("");
    }
}
