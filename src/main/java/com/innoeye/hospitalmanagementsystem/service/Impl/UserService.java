package com.innoeye.hospitalmanagementsystem.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innoeye.hospitalmanagementsystem.dao.UserDao;
import com.innoeye.hospitalmanagementsystem.model.User;
import com.innoeye.hospitalmanagementsystem.service.IScheduleService;
import com.innoeye.hospitalmanagementsystem.service.IUserService;

@Service
public class UserService  implements IUserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserDao userDao;

	@Override
	public Boolean check(User user) {
		// TODO Auto-generated method stub
		List<User> users=userDao.findAll();
		
		
		for(User use:users) {
			if(use.getUserName().equals(user.getUserName())&&use.getPassword().equals(user.getPassword())) {
				logger.info("login sucessfull.");
				return true;
			}
		}
		return false;
	}
	
	
}
