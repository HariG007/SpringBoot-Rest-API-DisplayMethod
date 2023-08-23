package com.harig.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harig.user.model.User;


public interface UserRepository extends JpaRepository<User,Integer>{

	boolean existsByEmail(String Email);
	Optional<User> findById(Long id);
	void deleteById(Long id);
	
}
