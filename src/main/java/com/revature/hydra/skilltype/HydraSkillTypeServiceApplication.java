package com.revature.hydra.skilltype;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Skilltype service main class
 */
@SpringBootApplication
@EnableSwagger2
//@EnableEurekaClient
@EntityScan("com.revature.beans")
@EnableRabbit
public class HydraSkillTypeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HydraSkillTypeServiceApplication.class, args);
	}
}
