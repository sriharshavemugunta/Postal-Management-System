package com.cs.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.cs.api")
@EnableJpaRepositories
public class PostalManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostalManagementApplication.class, args);
	}

}
