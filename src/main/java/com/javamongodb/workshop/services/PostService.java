package com.javamongodb.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javamongodb.workshop.domain.Post;
import com.javamongodb.workshop.domain.User;
import com.javamongodb.workshop.repository.PostRepository;
import com.javamongodb.workshop.services.exception.ObjectNotFoundException;

@Service // falar pro spring q e um servico q pode injetavel em outras classes
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
	}

	public List<Post> findALL(){
		return postRepository.findAll();
	}
}
