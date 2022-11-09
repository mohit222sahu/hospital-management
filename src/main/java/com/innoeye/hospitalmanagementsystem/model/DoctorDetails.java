package com.innoeye.hospitalmanagementsystem.model;

import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import net.bytebuddy.asm.Advice.This;

@Entity
@Table(name = "doctor_details")
public class DoctorDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;


	public DoctorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
   
	
	@Column(name = "doctor_id")
	private String doctorId;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "age")
	private Integer age;

	@Column(name = "contact_number")
	private String contactNumber;

	@Column(name = "email")
	private String email;

	@Column(name = "address")
	private String address;

	@Column(name = "specialization")
	private String specialization;

	@Column(name = "qualification")
	private String qualification;
	
	@Column(name = "fee")
	private Double fee;


	public void setId(Integer id)
	{
		this.id=id;}
	public Integer getId() {
		return this.id;
	}
	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
		}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	public Double getFee() {
		return this.fee;
	}

	public DoctorDetails(String doctorId, String firstName, String lastName, Integer age, String contactNumber,
			String email, String address, String specialization, String qualification, Double fee) {
		super();
		this.doctorId = doctorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.contactNumber = contactNumber;
		this.email = email;
		this.address = address;
		this.specialization = specialization;
		this.qualification = qualification;
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "DoctorDetails [doctorId=" + doctorId + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age + ", contactNumber=" + contactNumber + ", email=" + email + ", address=" + address
				+ ", specialization=" + specialization + ", qualification=" + qualification + ",fee=" + fee + "]";
	}
}
