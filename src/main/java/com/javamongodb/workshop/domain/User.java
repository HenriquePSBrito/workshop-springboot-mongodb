package com.javamongodb.workshop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user") //@Document e @Id para indicar que se trata de uma coleção do MongoDB
//senao usar o (collection) (opcional) é pego automaticamente o nome da classe User de forma minuscula.
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
		
	@Id	
	private String id;
	private String name;
	private String email;
	
	@DBRef(lazy=true) //atributo referenciando outra colecao do mongodb
	//lazy true - nao carrega os posts automaticamente - nao traz dados desnecessarios
	private List<Post> posts = new ArrayList<>();
	
	
	public User() {
	}
	
	public User(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}	
	
}
