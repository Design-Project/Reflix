package com.reflix.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		System.setProperty("user.timezone", "Asia/Seoul");
		SpringApplication.run(ServerApplication.class, args);

	}

}
