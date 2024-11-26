package com.clinic.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.clinic.model.Doctors;

public interface DoctorsRepo extends JpaRepository<Doctors, Long>{

	Doctors findByName(String name);

	
}
