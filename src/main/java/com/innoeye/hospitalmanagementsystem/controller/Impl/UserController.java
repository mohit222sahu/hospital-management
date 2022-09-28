package com.innoeye.hospitalmanagementsystem.controller.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.innoeye.hospitalmanagementsystem.controller.IUserController;
import com.innoeye.hospitalmanagementsystem.model.User;
import com.innoeye.hospitalmanagementsystem.service.IUserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController implements IUserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	
	@Autowired
	private IUserService  userService;
	@Override
	public String msg() {
		return "logged in";
	}
	
	@Override
	public Boolean check(User user) {
		logger.info("loging request by admin");
		System.out.println("user==>"+user.getPassword()+"  " +user.getUserName());
		return userService.check(user);
	}

}
