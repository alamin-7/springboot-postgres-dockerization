package com.docker.DockerSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DockerSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerSpringBootApplication.class, args);
	}

}
