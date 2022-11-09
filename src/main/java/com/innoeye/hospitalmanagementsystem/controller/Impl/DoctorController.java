package com.innoeye.hospitalmanagementsystem.controller.Impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innoeye.hospitalmanagementsystem.HospitalmanagementsystemApplication;
import com.innoeye.hospitalmanagementsystem.controller.IDoctorController;
import com.innoeye.hospitalmanagementsystem.model.DoctorDetails;
import com.innoeye.hospitalmanagementsystem.service.IDoctorService;
@RestController
public class DoctorController implements IDoctorController {

	@Autowired
	IDoctorService doctorService;

	private static final Logger logger = LoggerFactory.getLogger(DoctorController.class);

	public List<DoctorDetails> getAll(){
		logger.info("getting All doctors");
		return doctorService.getAll();
	}

	@Override
	public DoctorDetails addDoctor(DoctorDetails doctor){

		logger.info("Creating a Doctor");
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
}
