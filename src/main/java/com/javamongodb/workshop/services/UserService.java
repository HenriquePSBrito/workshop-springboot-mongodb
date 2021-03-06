package com.javamongodb.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javamongodb.workshop.domain.User;
import com.javamongodb.workshop.dto.UserDTO;
import com.javamongodb.workshop.repository.UserRepository;
import com.javamongodb.workshop.services.exception.ObjectNotFoundException;

@Service //falar pro spring q e um servico q pode injetavel em outras classes
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findALL(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
	}
	
	public User insert(User obj) {
		return userRepository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj); //responsavel por copiar os objetos de obj pro newObj
		return userRepository.save(newObj);
		}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
