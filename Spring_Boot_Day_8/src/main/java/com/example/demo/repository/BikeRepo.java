package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Bike;

public interface BikeRepo extends JpaRepository<Bike, Integer> {
	
	@Query(value = "select * from Bike where year = :y",nativeQuery = true)
	public List<Bike> fetchYear(@Param("y")int year);
	
	@Query(value = "select * from Bike where year = :y or bike_name like %:bn%",nativeQuery = true)
	public List<Bike> fetchYearAndBike(@Param("y")int year, @Param("bn")String name);
	
	@Query(value = "select * from Bike where bike_name like %:bn%",nativeQuery = true)
	public List<Bike> fetchBikeName(@Param("bn") String name);
}
