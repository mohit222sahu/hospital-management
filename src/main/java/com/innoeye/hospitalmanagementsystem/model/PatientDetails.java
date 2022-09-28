package com.innoeye.hospitalmanagementsystem.model;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient_details")
public class PatientDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id_pk")
	private Integer id;

	@Column(name = "patient_first_name")
	private String first_name;

	@Column(name = "patient_last_name")
	private String last_name;

	@Column(name = "gender")
	private String gender;

	@Column(name = "age")
	private Integer age;

	@Column(name = "mobile_number", unique = true)
	private String mobile_number;

	@Column(name = "city")
	private String city;

	@Column(name = "emergencyContactNumber")
	private String emergencyContactNumber;

	@Column(name = "address")
	private String address;
	
	@Column(name="email")
	private String email;
	
	
	public PatientDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public String toString() {
		return "PatientDetails [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", gender="
				+ gender + ", age=" + age + ", mobile_number=" + mobile_number + ", city=" + city
				+ ", emergencyContactNumber=" + emergencyContactNumber + ", address=" + address + ", email=" + email
				+ "]";
	}



	public PatientDetails(Integer id, String first_name, String last_name, String gender, Integer age,
			String mobile_number, String city, String emergencyContactNumber, String address) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.age = age;
		this.mobile_number = mobile_number;
		this.city = city;
		this.emergencyContactNumber = emergencyContactNumber;
		this.address = address;
		this.email=email;
	}
	
	public String getEmail()
	{
		return email;
		
	}
	public void setEmail() {
		this.email= email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmergencyContactNumber() {
		return emergencyContactNumber;
	}

	public void setEmergencyContactNumber(String emergencyContactNumber) {
		this.emergencyContactNumber = emergencyContactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}