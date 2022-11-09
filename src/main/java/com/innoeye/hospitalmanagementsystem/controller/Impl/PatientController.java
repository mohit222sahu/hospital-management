//package com.innoeye.hospitalmanagementsystem.controller.Impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.innoeye.hospitalmanagementsystem.controller.IPatientController;
//import com.innoeye.hospitalmanagementsystem.entity.PatientDetails;
//import com.innoeye.hospitalmanagementsystem.service.IPatientService;
//@CrossOrigin
//@RestController
//@RequestMapping("/patient")
//public class PatientController implements IPatientController{
//	@Autowired
//	IPatientService patientService;
//		//Done
//	
//	public PatientDetails addPatient(@RequestBody PatientDetails patient) {
//		return patientService.addPatient(patient);
//	}
//	//Done
//	
//	public List<PatientDetails> patientList() {
//		return patientService.patientList();
//	}
//	//Done
//	
//	public PatientDetails getById(@RequestParam Integer id) {
//		return patientService.getById(id);
//	}
//	//Done
//	
//	public void deletePatient(Integer id) {
//		patientService.deletePatient(id);		
//	}
//
//	@Override
//	public void updatePatient(PatientDetails patient) {
//		patientService.updatePatient(patient);
//		
//	}
//
//	@Override
//	public List<PatientDetails> filterByName(String name) {
//		// TODO Auto-generated method stub
//		return patientService.filterByName(name);
//	}
//
//}

package com.innoeye.hospitalmanagementsystem.controller.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.innoeye.hospitalmanagementsystem.controller.IPatientController;
import com.innoeye.hospitalmanagementsystem.model.PatientDetails;
import com.innoeye.hospitalmanagementsystem.service.IPatientService;
@RestController
public class PatientController implements IPatientController{
	
	private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	IPatientService patientService;

	public ResponseEntity<PatientDetails> addPatient(@RequestBody PatientDetails patient) {
		logger.info("Creating a patient");

		ResponseEntity<PatientDetails> patientObject = patientService.addPatient(patient);
		if(patientObject!=null )
			logger.info("patient sucessfully created ");
			return  patientObject;
	}
	
	public ResponseEntity<List<PatientDetails>> patientList() {
		logger.info("patientList method called ");
		return patientService.patientList();
	}
	
	public ResponseEntity<PatientDetails> getById(@RequestParam Integer id) {
		logger.info("getting patient  by id "+id);
		 		ResponseEntity<PatientDetails> patientObject1= patientService.getById(id);
				logger.info("data fatched sucessfully");
				return patientObject1;
	}
	
	public ResponseEntity<HttpStatus> deletePatient(Integer id) {
		logger.info("deleting patient  by id"+id);
		return patientService.deletePatient(id);		
	}

	@Override
	public ResponseEntity<HttpStatus> updatePatient(PatientDetails patient) {
		logger.info("updating patient ");
		ResponseEntity<HttpStatus>  status= patientService.updatePatient(patient);
		if(status!=null)
			logger.info("patient updated sucessfully ");
		return status;
		
	}

}

