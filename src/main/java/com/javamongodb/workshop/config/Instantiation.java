package com.javamongodb.workshop.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.javamongodb.workshop.domain.User;
import com.javamongodb.workshop.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll(); //vai zerar a coleção no mongodb
		
		User gabi = new User(null, "Gabi Martins", "gabi@gmail.com");
		User josy = new User(null, "Josy Brito", "josydsb@gmail.com");
		User larissa = new User(null, "Larissa Macedo", "larissa@gmail.com");

		userRepository.saveAll(Arrays.asList(gabi, josy, larissa));
	}

}