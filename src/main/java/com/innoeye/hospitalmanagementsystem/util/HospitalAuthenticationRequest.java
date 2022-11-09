package com.innoeye.hospitalmanagementsystem.util;

public class HospitalAuthenticationRequest {

	private String userName;

	private String password;

	public HospitalAuthenticationRequest() {

	}

	public HospitalAuthenticationRequest(String userName, String password) {
		this.setuserName(userName);
		this.setPassword(password);
	}

	public String getuserName() {
		return this.userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
