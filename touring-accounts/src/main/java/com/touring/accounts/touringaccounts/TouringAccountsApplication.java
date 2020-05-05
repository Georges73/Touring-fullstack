package com.touring.accounts.touringaccounts;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class TouringAccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TouringAccountsApplication.class, args);
	}

}
