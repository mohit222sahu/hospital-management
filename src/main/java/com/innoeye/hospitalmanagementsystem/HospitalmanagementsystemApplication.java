package com.innoeye.hospitalmanagementsystem;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration(exclude = {
	org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class })
public class HospitalmanagementsystemApplication {

	public static void main(String[] args) {
		System.out.println("Boot started 12345");
		SpringApplication.run(HospitalmanagementsystemApplication.class, args);
		System.out.println("Booting done");
	}

	@Bean
	public Docket swaggerConfrguration() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.innoeye"))
				.build().apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo("My Hospital API", "Sample API for My Hospital", "1.0", "Free to Use",
				new springfox.documentation.service.Contact("Shlok Malviya", "http://localhost//4200",
						"shlokmal@gmail.com"),
				"API License", "http://localhost//4200", Collections.emptyList());
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurerAdapter() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**")
	                    .allowedOrigins("http://localhost:4200")
	                    .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD","OPTIONS")
	                    .allowedHeaders("Content-Type", "Date", "Total-Count", "loginInfo","jwt_token")
	                    .exposedHeaders("Content-Type", "Date", "Total-Count", "loginInfo", "jwt_token")
	                    .maxAge(3600);
	        }
	    };
	}
	
	
}
