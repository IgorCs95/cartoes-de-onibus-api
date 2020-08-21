package com.controle.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CartoesOnibusApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartoesOnibusApiApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/user/**").allowedOrigins("http://localhost:4200").allowedMethods("GET","POST","PUT","DELETE");
				
				registry.addMapping("/cartao/**").allowedOrigins("http://localhost:4200").allowedMethods("GET","POST","PUT","DELETE");

			}
		};
	}

}
