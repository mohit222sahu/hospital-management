package com.innoeye.hospitalmanagementsystem.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.innoeye.hospitalmanagementsystem.annotation.AuthorizeUser;
import com.innoeye.hospitalmanagementsystem.model.DoctorDetails;

import io.swagger.annotations.ApiOperation;
@RequestMapping("/doctor")
@CrossOrigin(origins = "http://localhost:4200/")
public interface IDoctorController {

	@GetMapping(path="/getAll")
	@ApiOperation(value = "Return Doctor Details List",
	response = DoctorDetails.class)
	public ResponseEntity<List<DoctorDetails>> getAll();
	
	@PostMapping(path="/addDoctor")
	@ApiOperation(value = "Add Doctor Details",
	response = DoctorDetails.class)
	public DoctorDetails addDoctor(@RequestBody DoctorDetails doctor );
	
	
	@GetMapping(path="/getDoctorById/{doctorId}")
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
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex);
	
	@GetMapping(path="/customHeader")
	@ApiOperation(value = "Delete  Doctor Details By Id")
	public ResponseEntity<String> customHeader();
	
} 
