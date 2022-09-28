package com.innoeye.hospitalmanagementsystem.authentication.model;

import org.springframework.stereotype.Component;


public class HospitalAuthenticationResponse {
	private final String token;

	public HospitalAuthenticationResponse(String token) {
		this.token = token;
	}

	public String getJwt() {
		return token;
	}
}
