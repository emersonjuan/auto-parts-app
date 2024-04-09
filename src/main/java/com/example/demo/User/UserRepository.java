package com.example.demo.User;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserClass, Long>{

	List<UserClass> findByfName(String fName);
	List<UserClass> findByRole(String role);
	
}
