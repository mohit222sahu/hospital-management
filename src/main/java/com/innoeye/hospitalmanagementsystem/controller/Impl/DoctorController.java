package com.innoeye.hospitalmanagementsystem.controller.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innoeye.hospitalmanagementsystem.annotation.AuthorizeUser;
import com.innoeye.hospitalmanagementsystem.controller.IDoctorController;
import com.innoeye.hospitalmanagementsystem.model.DoctorDetails;
import com.innoeye.hospitalmanagementsystem.service.IDoctorService;
@CrossOrigin("/*")
@RestController
@RequestMapping(path="/doctor")
public class DoctorController implements IDoctorController {

	@Autowired
	IDoctorService doctorService;

	private static final Logger logger = LoggerFactory.getLogger(DoctorController.class);

	public ResponseEntity<List<DoctorDetails>> getAll(){
		logger.info("getting All doctors");
		List<DoctorDetails> list = doctorService.getAll();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header", "foo");
		
		 return  ResponseEntity.status(HttpStatus.OK).headers(headers).body(list);


	}
	
	@Autowired
	public ResponseEntity<String> customHeader() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Custom-Header", "foo");
	        
	    return new ResponseEntity<>(
	      "Custom header set", headers, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	@AuthorizeUser
	public DoctorDetails addDoctor(DoctorDetails doctor){
		System.out.println("Creating a Doctor");
		return doctorService.addDoctor(doctor);
	}


	@Override
	public DoctorDetails getDoctorById(String doctorId) {
		logger.info("getting the doctor, Id:" + doctorId);
		return doctorService.getById(doctorId);

	}

	@Override
	public String delete(Integer id) {
		logger.info("Deleting the Doctor, Id:" + id);
		return doctorService.deleteDoctor(id);


	}

	@Override
	public DoctorDetails updateDoctor(DoctorDetails doctor) {
		logger.info("updating the Doctor, Id:" + doctor);
		return doctorService.updateDoctor(doctor);
	}

	@Override
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		{
			Map<String, String> errors = new HashMap<>();

			ex.getBindingResult().getFieldErrors().forEach(error ->
			errors.put(error.getField(), error.getDefaultMessage()));
			return errors;
		}

	}
}
