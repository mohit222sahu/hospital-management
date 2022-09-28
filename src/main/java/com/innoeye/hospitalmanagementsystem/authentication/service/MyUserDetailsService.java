package com.innoeye.hospitalmanagementsystem.authentication.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.innoeye.hospitalmanagementsystem.dao.UserDao;
import com.innoeye.hospitalmanagementsystem.exceptions.HospitalException;
import com.innoeye.hospitalmanagementsystem.model.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String userName) throws HospitalException {
		User user;
		try {
			System.out.println("inside loadUserByUsername = "+userName);
			user = userDao.getUserDetailsByParameters(userName);
			
			if (user == null) {
				throw new HospitalException("User not found with username: " + userName);
			}
			System.out.println("user name is "+ user);
			return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),new ArrayList<>());
		} catch (HospitalException e) {
			throw e;
		}
	}
}
