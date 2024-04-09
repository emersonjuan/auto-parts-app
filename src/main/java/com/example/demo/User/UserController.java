package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.*;

@RestController
@RequestMapping("/api")

public class UserController {
    
	@Autowired
	UserRepository UserRepository;

}
