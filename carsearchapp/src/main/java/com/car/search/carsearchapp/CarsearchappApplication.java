package com.car.search.carsearchapp;

/**
 * Main entry point for the Car Search web application.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan(basePackages = {"com.car.search.carsearchapp.*"})
@EnableWebMvc
public class CarsearchappApplication {

	public static void main(String[] args) { 
		SpringApplication.run(CarsearchappApplication.class, args);
	}

}
