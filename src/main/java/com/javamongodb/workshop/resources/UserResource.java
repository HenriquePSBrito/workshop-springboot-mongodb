package com.javamongodb.workshop.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javamongodb.workshop.domain.User;

@RestController //falar q a classe é um rest 
@RequestMapping(value="/users") //caminho do endpoint
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET) //ou @GetMapping
	public ResponseEntity<List<User>> findAll(){
		User pedro = new User("1", "Pedro Marinho", "pedro@email.com");
		User carol = new User("2", "Carol Lagosta", "carol@email.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(pedro, carol));
		return ResponseEntity.ok().body(list);
	}

}
