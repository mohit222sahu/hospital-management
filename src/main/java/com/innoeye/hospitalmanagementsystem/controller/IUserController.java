package com.innoeye.hospitalmanagementsystem.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.innoeye.hospitalmanagementsystem.model.User;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/user")
public interface IUserController {
	
	@GetMapping("/getuser")
	String msg();
	
	@PostMapping("/check")
	Boolean check(@RequestBody User user);

}
