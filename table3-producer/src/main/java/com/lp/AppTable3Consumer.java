package com.lp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AppTable3Consumer {

	public static void main(String[] args) {
		SpringApplication.run(AppTable3Consumer.class, args);
	}
}
