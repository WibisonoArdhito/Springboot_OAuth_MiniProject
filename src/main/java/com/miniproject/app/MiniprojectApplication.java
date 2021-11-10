package com.miniproject.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.miniproject.app.service.UsersService;
import com.miniproject.app.service.UsersServiceImpl;

@SpringBootApplication
public class MiniprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniprojectApplication.class, args);
	}
	
	@Bean
	public UsersService userService() {
		return new UsersServiceImpl();
	}

}
