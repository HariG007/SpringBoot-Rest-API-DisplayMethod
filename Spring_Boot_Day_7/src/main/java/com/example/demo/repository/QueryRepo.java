package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QueryRepo extends JpaRepository<Query, Integer>{

	List<Query> findAllQuery();

	void updateUser(String price, Long id);

	void deleteUser(int id);

}
