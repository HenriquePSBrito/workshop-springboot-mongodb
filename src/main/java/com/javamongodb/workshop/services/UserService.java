package com.javamongodb.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javamongodb.workshop.domain.User;
import com.javamongodb.workshop.repository.UserRepository;

@Service //falar pro spring q e um servico q pode injetavel em outras classes
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findALL(){
		return userRepository.findAll();
	}
	
}
