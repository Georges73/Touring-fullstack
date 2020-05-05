package com.achille.eureka.touringeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TouringEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TouringEurekaApplication.class, args);
	}

}
