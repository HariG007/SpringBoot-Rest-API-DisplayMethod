package com.harig.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harig.user.model.User;
import com.harig.user.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired//in-order to access database
	private UserService userService;//object declaration
	@GetMapping("/getuser")
	public ResponseEntity<List<User>> getUser()
	{
		return ResponseEntity.status(200).body(userService.getUser());
		//ResponseEntity represents an HTTP response and also allows us to add headers and status code
	}
	@PostMapping("/adduser")
	public ResponseEntity<String> addUser(@RequestBody User user) //to get the data from API body
	{
		boolean dataSaved = userService.addUser(user);
		if(dataSaved)
		{
			return ResponseEntity.status(200).body("User added Successfully");//success response(200)
		}
		else
		{
			return ResponseEntity.status(404).body("Something went wrong!!");
		}
		
	}
	@PutMapping("/updateuser/{id}")//{path variable}
	public ResponseEntity<String> updateUser(@PathVariable Long id,@RequestBody User user)
	{
		boolean userData = userService.updateUser(id,user);
		if(userData)
		{
			return ResponseEntity.status(200).body("User Updated Successfully");
		}
		else
		{
			return ResponseEntity.status(404).body("No Record Found to be Updated!");
		}
	}
	//?-->RequestParam
	@DeleteMapping("/deleteuser/{id}")//using {path variable}
	public ResponseEntity<String> deleteUser(@PathVariable Long id)//Instead of using @Transactional -->>  we can use @RequestParam 
	{
		boolean userDeleted = userService.deleteUser(id);
		if(userDeleted)
		{
			return ResponseEntity.status(200).body("User Deleted Successfully");
		}
		else
		{
			return ResponseEntity.status(404).body("No Record Found to be Delete!");
		}
	}
}
