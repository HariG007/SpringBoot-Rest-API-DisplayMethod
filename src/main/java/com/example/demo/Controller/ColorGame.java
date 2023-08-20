package com.example.demo.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColorGame {

	private String color="Blue";
	
    @GetMapping("/color")
    public String getColor()
    {
  	   return "My favourite color is "+color;
    }
}
