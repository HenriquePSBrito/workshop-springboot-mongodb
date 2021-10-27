package com.javamongodb.workshop.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javamongodb.workshop.domain.User;
import com.javamongodb.workshop.services.UserService;

@RestController // falar q a classe é um rest
@RequestMapping(value = "/users") // caminho do endpoint
public class UserResource {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET) // ou @GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findALL();
		return ResponseEntity.ok().body(list);
	}

}
