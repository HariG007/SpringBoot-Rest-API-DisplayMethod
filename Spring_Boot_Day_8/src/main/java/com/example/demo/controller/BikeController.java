package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Bike;
import com.example.demo.service.BikeService;

@RestController
public class BikeController {
	@Autowired
	BikeService bs;
	
	@PostMapping("/")
	public boolean insertBike(@RequestBody List<Bike> b)
	{
		try {
			bs.addBikes(b);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	@GetMapping("/year/{year}")
	public List<Bike> getBikesOnYear(@PathVariable(value="year") int year)
	{
		return bs.showBikeOnYear(year);
	}
	
	@GetMapping("/year/{year}/bikeName/{bikeName}")
	public List<Bike> getBikesOnYearAndName(@PathVariable(value="year") int year, @PathVariable(value="bikeName") String name)
	{
		return bs.showBikeOnYearAndName(year, name);
	}
	
	@GetMapping("/bikeName/{bikeName}")
	public List<Bike> getBikesOnName(@PathVariable(value="bikeName") String name)
	{
		return bs.showBikeOnName(name);
	}


}
