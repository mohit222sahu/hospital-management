//package com.innoeye.hospitalmanagementsystem.controller;
//import com.innoeye.hospitalmanagementsystem.entity.*;
//
//import io.swagger.annotations.ApiOperation;
//
//import java.util.List;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@RequestMapping("/patient")
//public interface IPatientController {
//	
//	@PostMapping("/addPatient")
//	@ApiOperation(value = "Add Patient Details",
//	response = PatientDetails.class)
//	public PatientDetails addPatient(PatientDetails patient);
//	@GetMapping("/patientList")
//	@ApiOperation(value = "Get Patient Details List",
//	response = PatientDetails.class)
//	public List <PatientDetails> patientList();
//	@GetMapping("/getById")
//	@ApiOperation(value = "Get Patient Details By Id",
//	response = PatientDetails.class)
//	public PatientDetails getById(Integer id);
//	@GetMapping("/deletePatient/{id}")
//	@ApiOperation(value = "Delete Patient Details By Id")
//	public void deletePatient(@PathVariable Integer id);
//    @PostMapping("/updatePatient")
//    @ApiOperation(value = "Update Patient Details",
//	response = PatientDetails.class)
//    public void updatePatient(PatientDetails patient);
//    @GetMapping("/filterByName/{name}")
//    @ApiOperation(value = "Filter Patient Details By Patient Name",
//	response = PatientDetails.class)
//    public List<PatientDetails> filterByName(@PathVariable String name);
//    
//    
//  
//    
//    
//    
//    
//}



package com.innoeye.hospitalmanagementsystem.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.innoeye.hospitalmanagementsystem.model.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/patient")
public interface IPatientController {
	
	@PostMapping("/addPatient")
	public ResponseEntity<PatientDetails> addPatient(PatientDetails patient);
	
	@GetMapping("/patientList")
	public  ResponseEntity<List <PatientDetails>> patientList();
	
	
	@GetMapping("/getById")
	public ResponseEntity<PatientDetails> getById(Integer id);
	
	
	@GetMapping("/deletePatient/{id}")
	public ResponseEntity<HttpStatus> deletePatient(@PathVariable Integer id);
    
	
	@PostMapping("updatePatient")
    public ResponseEntity<HttpStatus> updatePatient(PatientDetails patient);
}
