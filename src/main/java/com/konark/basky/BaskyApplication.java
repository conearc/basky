package com.konark.basky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BaskyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaskyApplication.class, args);
	}

}
