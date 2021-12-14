package com.mb.app.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringbootMbappWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMbappWsApplication.class, args);
	}

}
