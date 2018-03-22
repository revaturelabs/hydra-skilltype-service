package com.revature.hydra.skilltype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.revature.beans")
public class HydraSkillTypeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HydraSkillTypeServiceApplication.class, args);
	}
}
