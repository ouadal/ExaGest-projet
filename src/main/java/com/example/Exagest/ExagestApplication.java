package com.example.Exagest;

import com.example.Exagest.security.entities.Role;
import com.example.Exagest.security.repositories.RoleRepository;
import com.example.Exagest.security.repositories.UserRepository;
import com.example.Exagest.security.requests.AdminRegisterRequest;
import com.example.Exagest.security.services.UserService;

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

			RoleRepository roleRepository,
			UserService userService,
			UserRepository userRepository
	) {
		return args -> {
			if (roleRepository.findByName("ROLE_OPERATEUR").isEmpty()) {
				roleRepository.save(
						Role
								.builder()
								.id(null)
								.name("ROLE_OPERATEUR")
								.build()
				);
			}


			if (roleRepository.findByName("ROLE_USER").isEmpty()) {
				roleRepository.save(
						Role
							.builder()
							.id(null)
							.name("ROLE_USER")
							.build()
				);
			}

			if (roleRepository.findByName("ROLE_ADMIN").isEmpty()) {
				roleRepository.save(
						Role
								.builder()
								.id(null)
								.name("ROLE_ADMIN")
								.build()
				);
			}
		 	System.out.println("============================================DAM");
			if (userRepository.findByUsername("admin").isEmpty()) {
				userService.storeAdmin(new AdminRegisterRequest("admin","1234","ouadalissifou7@gmail.com"));
				System.out.println("============================================DAM");
			}

};}}
