package com.javamongodb.workshop.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javamongodb.workshop.domain.User;
import com.javamongodb.workshop.dto.UserDTO;
import com.javamongodb.workshop.services.UserService;

@RestController // falar q a classe é um rest
@RequestMapping(value = "/users") // caminho do endpoint
public class UserResource {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET) // ou @GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findALL();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
}
