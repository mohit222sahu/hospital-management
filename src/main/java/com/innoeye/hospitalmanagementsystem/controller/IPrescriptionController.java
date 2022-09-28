package com.innoeye.hospitalmanagementsystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.innoeye.hospitalmanagementsystem.model.PatientDetails;
import com.innoeye.hospitalmanagementsystem.model.PrescriptionDetails;

import io.swagger.annotations.ApiOperation;


@RequestMapping(path="/prescription")
public interface IPrescriptionController {

	@GetMapping(path="/getAll")
	@ApiOperation(value = "Get Prescription Details List",
	response = PrescriptionDetails.class)
	public List<PrescriptionDetails> getAll();
	
//	@PostMapping(path="/addPrescription")
//	@ApiOperation(value = "Add Prescription Details",
//	response = PrescriptionDetails.class)
	//public PrescriptionDetails addPrescription(@RequestBody PrescriptionDetails prescription );
	
//	@GetMapping(path="/deletePrescription/{prescriptionId}")
//	public void deletePrescription(@PathVariable String prescriptionId);
//	
//	@GetMapping(path="/getPrescriptionById/{prescriptionId}")
//	public PrescriptionDetails getPrescriptionById(@PathVariable String prescriptionId);
	
	@GetMapping("/getByPatientId/{id}")
	@ApiOperation(value = "Get Prescription Details By Patient Id",
	response = PrescriptionDetails.class)
	public List<PrescriptionDetails> getByPatientId(@PathVariable  Integer id);

	@PostMapping(path="/addPrescription")
	@ApiOperation(value = "Add Prescription Details",
	response = PrescriptionDetails.class)
	List<PrescriptionDetails> addPrescription(@RequestBody List<PrescriptionDetails> prescription);
}
