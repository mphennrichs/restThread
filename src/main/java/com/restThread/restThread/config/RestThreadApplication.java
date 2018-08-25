package com.restThread.restThread.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackages = "com.restThread")
@EnableJpaRepositories("com.restThread.restThread.repositories")
@EntityScan("com.restThread.restThread.domain")
public class RestThreadApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestThreadApplication.class, args);
	}
}
