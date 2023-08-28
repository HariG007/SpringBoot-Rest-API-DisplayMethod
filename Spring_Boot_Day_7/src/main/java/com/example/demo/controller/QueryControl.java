package com.example.demo.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.QueryService;

@RestController
public class QueryControl {
	@Autowired
	QueryService fser;
	
	@GetMapping("getit")
	public List<Query> show()
	{
		return fser.showinfo();
	}
	
	@GetMapping("/getQuery")
	public ResponseEntity<List<Query>> getQuery()
	{
		return ResponseEntity.status(200).body(fser.findAllQuery());
	}
 	
	@GetMapping("getId/{id}")
	public Optional<Query> showid(@PathVariable int id)
	{
		return fser.readid(id);
	}
	
	@PutMapping("updatequery")
	public void updateUserQuery(@PathVariable String price, @PathVariable Long id)
	{
		fser.updateUserQuery(price, id);
	}
	
	
	
	@PostMapping("add")
	public String add(@RequestBody Query fr) 
	{
		return  fser.create(fr);
	}
	
	@PutMapping("update/{id}")
	public Query updateId(@PathVariable int id, @RequestBody Query fr)
	{
		return fser.updateId(id, fr);
	}
	
	
	
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable int id)
	{
		return fser.deleteId(id);
	}
	
	
	
	@DeleteMapping("deleteQuery")
	public int deleteUserQuery(@PathVariable int id)
	{
		return fser.deleteUser(id);
	}
	
}