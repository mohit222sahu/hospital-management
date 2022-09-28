package com.innoeye.hospitalmanagementsystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.innoeye.hospitalmanagementsystem.authentication.model.HospitalAuthenticationRequest;
import com.innoeye.hospitalmanagementsystem.authentication.model.HospitalAuthenticationResponse;
import com.innoeye.hospitalmanagementsystem.exceptions.HospitalException;

@RequestMapping(path="/authentication")
public interface IHospitalAuthenticationController {

	@GetMapping(path = "/hello")
	public String ping();
	
	@PostMapping(path = "/authenticate")
	public ResponseEntity<HospitalAuthenticationResponse> createAuthenticationToken(HospitalAuthenticationRequest authenticationRequest)
		throws HospitalException;
	
}
