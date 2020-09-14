package com.example.services.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.services.domain.User;

@Repository
public interface IUserRepository extends CrudRepository<User, Integer> {
	
	public User findByName(String name);
	
}
