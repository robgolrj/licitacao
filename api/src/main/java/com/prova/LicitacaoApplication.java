package com.prova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LicitacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LicitacaoApplication.class, args);
	}
}
