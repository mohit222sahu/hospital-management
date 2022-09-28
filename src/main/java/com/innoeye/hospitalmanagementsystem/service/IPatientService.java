//package com.innoeye.hospitalmanagementsystem.service;
//
//import java.util.List;
//
//import com.innoeye.hospitalmanagementsystem.entity.PatientDetails;
//
//public interface IPatientService {
//	
//	public PatientDetails addPatient(PatientDetails patient);
//	public List <PatientDetails> patientList();
//	public PatientDetails getById(Integer id);
//	public void deletePatient(Integer id);
//	public void updatePatient(PatientDetails patient);
//	List<PatientDetails> filterByName(String name);
//	}
package com.innoeye.hospitalmanagementsystem.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.innoeye.hospitalmanagementsystem.model.PatientDetails;

public interface IPatientService {
	
	public ResponseEntity<PatientDetails> addPatient(PatientDetails patient);
	public  ResponseEntity<List <PatientDetails>> patientList();
	public  ResponseEntity<PatientDetails> getById(Integer id);
	public ResponseEntity<HttpStatus> deletePatient(Integer id);
	public ResponseEntity<HttpStatus> updatePatient(PatientDetails patient);

}
