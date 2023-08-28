package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.demo.repository.QueryRepo;

@Service
public class QueryService {
	@Autowired
	QueryRepo f;
	
	public List<Query> showinfo(){
		return f.findAll();
	}
	
	public Optional<Query> readid(int id) {
		return f.findById(id);
	}
	

	
	public Query updateId(int id, Query bk) {
		if(f.existsById(id)) {
			System.out.println("UPDATED SUCCESSFULLY");
			return f.saveAndFlush(bk);
		}
		else {
			System.out.println("Please enter a valid id");
			return bk;
		}
	}
	
	public String deleteId(int id) {
		if(f.existsById(id)) {
			f.deleteById(id);
			return "Deleted successfully";
		}
		else
			return "Enter a valid id to delete";
}
	public Page<Query> getAllUser(PageRequest pageRequest)
	{
		return f.findAll(pageRequest);
	}
	public List<Query> findAllQuery()
	{
		return f.findAllQuery();
	}
	public void updateUserQuery(String price, Long id)
	{
		f.updateUser(price, id);
	}
	public int deleteUser(int id)
	{
		f.deleteUser(id);
		return id;
	}

	public String create(Query fr) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
