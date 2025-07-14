package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.entity.Status;
import com.example.entity.Todo;
import com.example.repository.TodoRepository;

import jakarta.annotation.PostConstruct;

@EnableAutoConfiguration
@Configuration
@ComponentScan("com.example") // Include all java files under example folder to this app
@EntityScan(basePackages = "com.example.entity") 
@EnableJpaRepositories(basePackages = "com.example.repository")
public class DemoApplication {

	@Autowired
	private TodoRepository repository;

	@PostConstruct
	public void initDB(){
		List<Todo> todos = Stream.of(
			new Todo("Learn Spring Boot", Status.Pending)
		).collect(Collectors.toList());
		repository.saveAll(todos);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
