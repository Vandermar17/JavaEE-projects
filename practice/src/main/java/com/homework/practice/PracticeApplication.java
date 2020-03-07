package com.homework.practice;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.LazyInitializationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext=SpringApplication.run(PracticeApplication.class, args);

		UserService userService = applicationContext.getBean(UserService.class);

		UserEntity user = userService.createUser("firstName1", "lastName1", "email1@example.com");
		userService.createUser("firstName2", "lastName2", "email2@example.com");
		System.out.println(userService.findAll());
		System.out.println(userService.findByLastName("lastName1"));
		System.out.println(userService.findByWord("2"));
	}

}
