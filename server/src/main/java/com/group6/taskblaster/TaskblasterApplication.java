package com.group6.taskblaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class TaskblasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskblasterApplication.class, args);
	}

}
