package com.innoeye.hospitalmanagementsystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.innoeye.hospitalmanagementsystem.exceptions.HospitalException;
import com.innoeye.hospitalmanagementsystem.util.HospitalAuthenticationRequest;


@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/authenticate")
public interface HospitalAuthenticationRest {

	@PostMapping(path="/login")
	ResponseEntity<?> authenticate(@RequestBody HospitalAuthenticationRequest authenticationRequest)
			throws HospitalException;
}
