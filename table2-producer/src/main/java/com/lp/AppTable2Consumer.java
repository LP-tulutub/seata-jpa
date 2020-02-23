package com.lp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AppTable2Consumer {

	public static void main(String[] args) {
		SpringApplication.run(AppTable2Consumer.class, args);
	}
}
