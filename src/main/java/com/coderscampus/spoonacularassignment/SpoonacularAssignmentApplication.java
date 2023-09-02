package com.coderscampus.spoonacularassignment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableConfigurationProperties(SpoonacularProperties.class)
public class SpoonacularAssignmentApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(SpoonacularAssignmentApplication.class, args);
	}
	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
