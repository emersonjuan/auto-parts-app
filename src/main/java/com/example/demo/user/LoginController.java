package com.example.demo.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.response.MessageResponse;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	UserRepository userRepo;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User loginRequest){		
		try {
			Optional<User> userData = userRepo.findByEmail(loginRequest.getEmail());
			if (userData.isPresent()) {
				String password = userData.get().getPassword();
				if (password.equals(loginRequest.getPassword())) {
					return new ResponseEntity<>(userData,HttpStatus.OK);
				}
				MessageResponse msg = new MessageResponse("Incorrect password");
				return new ResponseEntity<>(msg, HttpStatus.FORBIDDEN);
			}
			MessageResponse msg = new MessageResponse("User or password incorrect");
			return new ResponseEntity<>(msg, HttpStatus.FORBIDDEN);
		}catch (Exception e) {
			MessageResponse msg = new MessageResponse("Server Error");
			return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
