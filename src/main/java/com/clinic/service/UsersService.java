package com.clinic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.exception.UserNotFoundException;
import com.clinic.model.Doctors;
import com.clinic.model.Users;
import com.clinic.repository.UsersRepo;


@Service
public class UsersService
{
	@Autowired
	private UsersRepo usersRepo;

	public List<Users> getAllUsers() {
		return usersRepo.findAll();
	}

	public Users addUpdateUser(Users users) {
		return usersRepo.save(users);
	}

	public void deleteUserById(long id) {
		
		usersRepo.deleteById(id);
		
	}

	public boolean checkEmail(String email) {
		return usersRepo.existsByEmail(email);
	}

	public Users UpdateUser(Users users) {
		return usersRepo.save(users);
		
	}

	public Users getUserById(long id)
	{
		Optional<Users> opt = usersRepo.findById(id);
		if(opt.isPresent())
		{
			return opt.get();
		}
		else
		{
			throw new UserNotFoundException("Id: "+id+"Not Found");
		}
	}

	public Users findUserById(long id)
	{
		return usersRepo.findById(id).get();
	}

	public void updateuser(String name, Users user) {
		
		Users users = usersRepo.findByName(name);
		System.out.print(name);
		users.setName(user.getName());
		users.setAddress(user.getAddress());
		users.setPhone(user.getPhone());
		users.setEmail(user.getEmail());
		users.setPassword(user.getPassword());
	
		
		
		usersRepo.save(users);
		
	}

	
	
	
	
	
	
}

