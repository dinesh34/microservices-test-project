package io.moviapp.moviedataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieDataServiceApplication {

	public static void main(String[] args) {
		System.out.println("Hellow World");
		SpringApplication.run(MovieDataServiceApplication.class, args);
	}

}
