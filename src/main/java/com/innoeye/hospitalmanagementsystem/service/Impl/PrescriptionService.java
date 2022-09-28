package com.innoeye.hospitalmanagementsystem.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innoeye.hospitalmanagementsystem.controller.Impl.PatientController;
import com.innoeye.hospitalmanagementsystem.dao.IPrescriptionDao;
import com.innoeye.hospitalmanagementsystem.model.PrescriptionDetails;
import com.innoeye.hospitalmanagementsystem.service.IPrescriptionService;

@Service
public class PrescriptionService implements IPrescriptionService {

	private static final Logger logger = LoggerFactory.getLogger(PrescriptionService.class);

	@Autowired
	IPrescriptionDao prescriptionDao;

	@Override
	public List<PrescriptionDetails> getAll() {
		
		logger.info("getAll method called ..");		
		
		logger.info("prescription records fatched  ..");		



		return prescriptionDao.findAll();
	}

	@Override
	public List<PrescriptionDetails> addPrescription(List<PrescriptionDetails> prescription) {
		logger.info("addPrescription method  called ..");		
		
		logger.info("prescription added sucessfull  ..");	
		List<PrescriptionDetails> list = new ArrayList<>();
		for(PrescriptionDetails obj: prescription) {
			PrescriptionDetails ob= prescriptionDao.save(obj);
			list.add(ob);
		}
		return list;
		
	}

	@Override
	public List<PrescriptionDetails> getByPatientId(Integer id) {
       logger.info("getByPatientId method  called ..");		
		
		logger.info("getByPatientId sucessfully executed...");			
				return prescriptionDao.findBypatient_id(id);
	}

}
