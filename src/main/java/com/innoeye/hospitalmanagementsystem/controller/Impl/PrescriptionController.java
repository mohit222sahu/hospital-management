package com.innoeye.hospitalmanagementsystem.controller.Impl;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innoeye.hospitalmanagementsystem.controller.IPrescriptionController;
import com.innoeye.hospitalmanagementsystem.model.PrescriptionDetails;
import com.innoeye.hospitalmanagementsystem.service.IPrescriptionService;
@CrossOrigin
@RestController

public class PrescriptionController implements IPrescriptionController {
	private static final Logger logger = LoggerFactory.getLogger(PrescriptionController.class);

	
	@Autowired
	IPrescriptionService prescriptionService;
	@Override
	public List<PrescriptionDetails> getAll(){
		logger.info("getting all prescriptions");
		return prescriptionService.getAll();
	
}

	@Override
	public List<PrescriptionDetails> addPrescription(List<PrescriptionDetails> prescriptionList) {
		logger.info("adding new  prescription");
		return prescriptionService.addPrescription(prescriptionList);
	}

//	@Override
//	public void deletePrescription(String prescriptionId) {
//		prescriptionService.deletePrescription(prescriptionId);
//	}

//	@Override
//	public PrescriptionDetails getPrescriptionById(String prescriptionId) {
//		// TODO Auto-generated method stub
//		return prescriptionService.getById(prescriptionId);
//	}
	
	@Override
	public List<PrescriptionDetails> getByPatientId(Integer id) {
		logger.info("getting  a  prescription bu petient id :" +id);
		return prescriptionService.getByPatientId(id);
	}
}
