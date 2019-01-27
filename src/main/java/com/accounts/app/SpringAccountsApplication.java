package com.accounts.app;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.accounts.app.models.entity.Role;
import com.accounts.app.models.entity.User;
import com.accounts.app.models.service.UserService;

@SpringBootApplication
public class SpringAccountsApplication {

	@Bean
	public CommandLineRunner setupDefaultUser(UserService service) {
		return args -> {
			service.save(
					new User(
					"user", // username
					"user", // password
					Arrays.asList(new Role("USER"), new Role("ADMIN")), // roles
					true// Active
			));
		};
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringAccountsApplication.class, args);
	}

}
