package com.innoeye.hospitalmanagementsystem;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HospitalmanagementsystemApplication {

	public static void main(String[] args) {
		System.out.println("boot started");
		SpringApplication.run(HospitalmanagementsystemApplication.class, args);
		System.out.println("boot done");
	}

	@Bean
	public Docket swaggerConfrguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.innoeye"))
				.build()
				.apiInfo(apiDetails());
		
		
	}
	
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"My Hospital API",
				"Sample API for My Hospital",
				"1.0",
				"Free to Use",
				new springfox.documentation.service.Contact("Shlok Malviya", "http://localhost//4200", "shlokmal@gmail.com"),
				"API License",
				"http://localhost//4200",
				Collections.emptyList());
	}
}
