package com.teamx.petadopt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teamx.petadopt.model.User;
import com.teamx.petadopt.service.UserService;

@RestController//making restful web services
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired//in-order to access database
	private UserService userService;
	
	@GetMapping("/getdetails")
	public ResponseEntity<List<User>> getDetails()
	{
		return ResponseEntity.status(200).body(userService.getUser());
		//ResponseEntity represents an HTTP response and also allows us to add status code
	}
	
	@GetMapping("/getalluser")
	public ResponseEntity<Page<User>> getAllUser
	(@RequestParam(defaultValue = "0") int page, //Used to read the HTML form data provided by a user and bind it to the request parameter
	 @RequestParam(defaultValue = "10") int size,//Or Extract input data that may be passed as a query, form data, or any arbitrary custom data.
	 @RequestParam(defaultValue = "id") String sortField,
	 @RequestParam(defaultValue = "asc") String sortOrder
	 )//Return Page of user details
	{
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder),sortField));//Is a class and help us to get above data's
		return ResponseEntity.status(200).body(userService.getAllUser(pageRequest));
	}
	
	@PostMapping("/adddetails")
	public ResponseEntity<String> addDetails(@RequestBody User user) //to get the data from API body
	{
		boolean dataSaved = userService.addUser(user);
		if(dataSaved)
		{
			return ResponseEntity.status(200).body("Info added Successfully");//success response(200)
		}
		else
		{
			return ResponseEntity.status(404).body("Something went wrong!!");
		}
		
	}
	
	@PutMapping("/updatedetails/{id}")//{path variable}
	public ResponseEntity<String> updateUser(@PathVariable Long id,@RequestBody User user)//Instead of using @Transactional -->>  we can use @RequestParam 
	{
		boolean userData = userService.updateUser(id,user);
		if(userData)
		{
			return ResponseEntity.status(200).body("Info Edited Successfully");
		}
		else
		{
			return ResponseEntity.status(404).body("No Record Found to be Edit!");
		}
	}
	
	//?-->RequestParam
		@DeleteMapping("/deletedetails/{id}")//using {path variable}
		public ResponseEntity<String> deleteUser(@PathVariable Long id)//Instead of using @Transactional -->>  we can use @RequestParam 
		{
			boolean userDeleted = userService.deleteUser(id);
			if(userDeleted)
			{
				return ResponseEntity.status(200).body("Info Deleted Successfully");
			}
			else
			{
				return ResponseEntity.status(404).body("No Record Found to be Delete!");
			}
		}
}

//@RequestParam is used to capture query parameters or form parameters from the URL, 
//while @PathVariable is used to capture values from the URL path. 
