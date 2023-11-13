package com.sntechnologies.retailapp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {
    @Value("${retailapp.openapi.dev-url}")
    private String devUrl;

    @Value("${retailapp.openapi.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development Environment");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production Environment");

        Contact contact = new Contact();
        contact.setEmail("retailapp@gmail.com");
        contact.setName("retailapp");
        contact.setUrl("https://www.retailapp.com");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/license/mit/");

        Info info = new Info()
                .title("Retail Application API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage retailapp")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}
