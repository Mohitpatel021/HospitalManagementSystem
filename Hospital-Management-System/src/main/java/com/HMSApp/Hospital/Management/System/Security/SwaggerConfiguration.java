package com.HMSApp.Hospital.Management.System.Security;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
  info = @Info(
    contact = @Contact(name = "Mohit Patel", email = "Mohitpa021@gmail.com"),
    description = " It offers a centralized platform to efficiently handle administrative, operational, and clinical tasks",
    title = "Clinic Management System",
    version = "3.2.2",
    license = @License(name = "License_Name", url = "https://xyz-url.com"),
    termsOfService = "Terms of Service"
  ),
  servers = {
    @Server(description = "Local ENV", url = "hhtp://localhost:8080"),
  }
)
@SecurityScheme(
  name = "Bearer Jwt Authentication is Applied",
  type = SecuritySchemeType.HTTP,
  bearerFormat = "JWT",
  scheme = "Bearer"
)
public class SwaggerConfiguration {}
