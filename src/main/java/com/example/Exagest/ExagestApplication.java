package com.example.Exagest;

import com.example.Exagest.security.entities.Role;
import com.example.Exagest.security.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExagestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExagestApplication.class, args);
	}

	@Bean
	public CommandLineRunner start(
			RoleRepository roleRepository
	) {
		return args -> {
			if (roleRepository.count() == 0) {
				roleRepository.save(
						Role
							.builder()
							.id(null)
							.name("ROLE_USER")
							.build()
				);
			}
		};
	}
}
