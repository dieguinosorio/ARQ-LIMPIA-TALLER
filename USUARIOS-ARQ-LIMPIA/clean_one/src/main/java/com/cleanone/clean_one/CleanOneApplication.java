package com.cleanone.clean_one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cleanone.clean_one.infraestructure.drivenadapters")
public class CleanOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleanOneApplication.class, args);
	}

}
