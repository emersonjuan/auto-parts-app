package com.example.demo.user;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, Long>{
	
	List<User>findAllByfName(String fName);
	Optional<User> findByEmail(String email);
	List<User>findAllByRole(String role);
	
}
