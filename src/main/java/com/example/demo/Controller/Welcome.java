package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
	
   @GetMapping("/welcome")
   public String welcomeMsg()
   {
	   return "Welcome String Boot!";
   }
}
