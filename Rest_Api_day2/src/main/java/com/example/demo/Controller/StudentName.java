package com.example.demo.Controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentName {
	
@Value("${spring.demo.username}")
private String username;

@GetMapping("/show/username")
 public String PrintName()
 {
	return username;
 }
}
