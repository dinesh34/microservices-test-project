package io.moviapp.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker //only used in here because others services are called by this
@EnableHystrixDashboard
public class MovieCatalogServiceApplication {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    //Reactive web method to create a RestTemplate
    public WebClient.Builder getWebClientBuilder(){
        return WebClient.builder();
    }

	public static void main(String[] args) {
		System.out.println("Hellow World");
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}
