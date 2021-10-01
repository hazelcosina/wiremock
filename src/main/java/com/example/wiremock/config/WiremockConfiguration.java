package com.example.wiremock.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

@Configuration
public class WiremockConfiguration {

    @Value("${wiremock.host}")
    private String host;
    @Value("${wiremock.port}")
    private int port;
    @Value("${wiremock.stub.path}")
    private String path;

    @Bean
    void configure() {
        WireMockServer wireMockServer = new WireMockServer(options()
                .port(port)
                .usingFilesUnderDirectory(path)
        );
        wireMockServer.start();
        configureFor(host, port);

    }
}
