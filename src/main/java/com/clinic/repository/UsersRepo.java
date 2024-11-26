package com.clinic.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.clinic.model.Users;  

public interface UsersRepo extends JpaRepository<Users, Long> {

	boolean findByEmail(String email);

	Users findByEmailAndPassword(String email, String password);

	Users findByName(String name);

	boolean existsByEmail(String email);
	
	

	

}