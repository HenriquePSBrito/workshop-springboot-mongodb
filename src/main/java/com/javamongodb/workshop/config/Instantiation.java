package com.javamongodb.workshop.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.javamongodb.workshop.domain.Post;
import com.javamongodb.workshop.domain.User;
import com.javamongodb.workshop.dto.AuthorDTO;
import com.javamongodb.workshop.repository.PostRepository;
import com.javamongodb.workshop.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll(); //vai zerar a coleção no mongodb
		postRepository.deleteAll(); //limpar todos os posts no inicio do programa
			
		User gabi = new User(null, "Gabi Martins", "gabi@gmail.com");
		User josy = new User(null, "Josy Brito", "josydsb@gmail.com");
		User larissa = new User(null, "Larissa Macedo", "larissa@gmail.com");
		
		userRepository.saveAll(Arrays.asList(gabi, josy, larissa));
		
		Post post1 = new Post(null, sdf.parse("28/06/2019"), "Partiu viagem", "Vou viajar para o Rio de Janeiro. Abraços!", new AuthorDTO(gabi));
		Post post2 = new Post(null, sdf.parse("30/06/2019"), "Bom dia!", "Acordei feliz hoje!", new AuthorDTO(gabi));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		gabi.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(gabi);
		
	}

}