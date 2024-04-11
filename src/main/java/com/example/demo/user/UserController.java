package com.example.demo.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user){
		try {
			User newUser = new User(user.getfName(), user.getfName(), user.getEmail(), user.getPassword(), user.getRole());
			userRepo.save(newUser);
			return new ResponseEntity<>(newUser, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false)String fname){
		
		try {
			List<User> users = new ArrayList<User>();
			if(fname == null) {
				userRepo.findAll().forEach(users::add);
			}else {
				userRepo.findAllByfName(fname).forEach(users::add);
			}
			if(users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(users,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getCourseById(@PathVariable("id") long id) {
		Optional<User> userData = userRepo.findById(id);

		if (userData.isPresent()) {
			return new ResponseEntity<>(userData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateCourse(@PathVariable("id") long id, @RequestBody User user) {
		Optional<User> userData = userRepo.findById(id);

		if (userData.isPresent()) {
			User _user = userData.get();
			_user.setfName(user.getfName());
			_user.setlName(user.getlName());
			_user.setEmail(user.getEmail());
			_user.setPassword(user.getPassword());
			_user.setRole(user.getRole());
			return new ResponseEntity<>(userRepo.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<List<User>> deleteUser(@PathVariable("id")long id){
		try {
			userRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
