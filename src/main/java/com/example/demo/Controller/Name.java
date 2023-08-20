package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Name {

	private String Name="G";
  @GetMapping("/name")
  public String getName()
  {
	return "welcome "+Name+" !";
  }
}
