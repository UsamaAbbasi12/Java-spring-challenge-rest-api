package com.learning.leraning_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class LeraningSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeraningSpringApplication.class, args);
	}
}
