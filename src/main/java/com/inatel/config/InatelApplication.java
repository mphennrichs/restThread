package com.inatel.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackages = "com.inatel")
@EnableJpaRepositories("com.inatel.repositories")
@EntityScan("com.inatel.domain")
public class InatelApplication {

	public static void main(String[] args) {
		SpringApplication.run(InatelApplication.class, args);
	}
}
