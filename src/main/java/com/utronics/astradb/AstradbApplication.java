package com.utronics.astradb;

import com.utronics.astradb.connection.DataStaxAstraProperties;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.nio.file.Path;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "AstraDB Application",
		version = "1.0",
		description = "Cassandra Demo"
))
@EnableConfigurationProperties(DataStaxAstraProperties.class)
public class AstradbApplication {

	public static void main(String[] args) {
		SpringApplication.run(AstradbApplication.class, args);
	}

	@Bean
	public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraProperties) {
		Path bundle = astraProperties.getSecureConnectBundle().toPath();
		return builder -> builder.withCloudSecureConnectBundle(bundle);
	}
}
