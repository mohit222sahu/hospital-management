package com.innoeye.hospitalmanagementsystem.util;

public class HospitalAuthenticationResponse {
	private final String token;

	public HospitalAuthenticationResponse(String token) {
		this.token = token;
	}

	public String getJwt() {
		return token;
	}
}
