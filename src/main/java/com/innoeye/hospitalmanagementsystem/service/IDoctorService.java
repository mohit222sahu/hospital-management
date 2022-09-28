package com.innoeye.hospitalmanagementsystem.service;

import java.util.List;

import com.innoeye.hospitalmanagementsystem.model.DoctorDetails;

public interface IDoctorService {

	public List<DoctorDetails> getAll();

	public DoctorDetails addDoctor(DoctorDetails doctor);

	
	public DoctorDetails getById(String doctorId);

	
	DoctorDetails updateDoctor(DoctorDetails doctor);

	public String deleteDoctor(Integer id);

}
