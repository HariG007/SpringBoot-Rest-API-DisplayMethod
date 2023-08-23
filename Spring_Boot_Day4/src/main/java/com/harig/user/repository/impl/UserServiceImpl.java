package com.harig.user.repository.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.harig.user.model.User;
import com.harig.user.repository.UserRepository;
import com.harig.user.service.UserService;
import jakarta.transaction.Transactional;

@Service 
@Transactional//to delete data in the database using delete API request
public class UserServiceImpl implements UserService {

	@Autowired//in-order to access database
	 private UserRepository userRepository;//object
	
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		boolean userExists = userRepository.existsByEmail(user.getEmail());
		//To check if the record is present or not?
		if(!userExists)
		{
			userRepository.save(user);
			return true;
		}
		else
		{
			return false;
		}
		
	}

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();//retrieve list of data from the table
	}

	@Override
	public boolean updateUser(Long id,User user) {
//		userRepository.saveAndFlush(user);//Disadvantage of this method : It also insert data instead of update.
		Optional<User> existingUserOptional = userRepository.findById(id); //container object
		if(existingUserOptional.isPresent())
		{
		User userExists = existingUserOptional.get();
		userExists.setFirstname(user.getFirstname());
		userExists.setLastname(user.getLastname());
		userExists.setEmail(user.getEmail());
		userExists.setPassword(user.getPassword());
		userRepository.save(userExists);
		return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean deleteUser(Long id) {
		Optional<User> existingUserOptional = userRepository.findById(id);
		if(existingUserOptional.isPresent())
		{
			userRepository.deleteById(id);
			return true;
		}
		else
		{
			return false;
		}
		
	}

	

}
