package com.sprint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class Application implements CommandLineRunner {


	@Override
	public void run(String... args) {
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
