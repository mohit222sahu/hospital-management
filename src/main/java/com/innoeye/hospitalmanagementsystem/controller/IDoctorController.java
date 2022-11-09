package com.innoeye.hospitalmanagementsystem.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.innoeye.hospitalmanagementsystem.model.DoctorDetails;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/doctor")
public interface IDoctorController {

	@GetMapping(path="/getAll")
	@ApiOperation(value = "Return Doctor Details List",
	response = DoctorDetails.class)
	public List<DoctorDetails> getAll();
	
	@PostMapping(path="/addDoctor")
	@ApiOperation(value = "Add Doctor Details",
	response = DoctorDetails.class)
	public DoctorDetails addDoctor(@RequestBody DoctorDetails doctor );
	
	
	@GetMapping(path="/	/{doctorId}")
	@ApiOperation(value = "Get  Doctor Details By Id",
	response = DoctorDetails.class)
	public DoctorDetails getDoctorById(@PathVariable String doctorId);
	
	@GetMapping(path="/deleteDoctor/{id}")
	@ApiOperation(value = "Delete  Doctor Details By Id")
	public String delete(@PathVariable Integer id);
	
	@PostMapping(path="/updateDoctor")
	@ApiOperation(value = "Update Doctor Details",
	response = DoctorDetails.class)
	public DoctorDetails updateDoctor(@RequestBody DoctorDetails doctor);
	
} 
