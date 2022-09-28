package com.innoeye.hospitalmanagementsystem.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innoeye.hospitalmanagementsystem.controller.Impl.DoctorController;
import com.innoeye.hospitalmanagementsystem.dao.IDoctorDao;
import com.innoeye.hospitalmanagementsystem.dao.IScheduleDao;
import com.innoeye.hospitalmanagementsystem.model.DoctorDetails;
import com.innoeye.hospitalmanagementsystem.model.Schedule;
import com.innoeye.hospitalmanagementsystem.service.IDoctorScheduleService;
import com.innoeye.hospitalmanagementsystem.service.IDoctorService;

@Service
public class DoctorService implements IDoctorService {
	private static final Logger logger = LoggerFactory.getLogger(DoctorService.class);


	@Autowired
	IDoctorDao doctorDao;
	
	@Autowired
	IScheduleDao scheduleDao;

	@Override
	public List<DoctorDetails> getAll() {
		
		
		List<DoctorDetails> doctors= doctorDao.findAll();
		if(doctors.size()==0) {
			logger.trace("No record found ");
		}
		else 
		   logger.info("data fatched successfully ");
		return doctors;
		
	}
	
	final String doctorId = "DOC-";

	@Override
	public DoctorDetails addDoctor(DoctorDetails doctor)  {
		
				logger.info("addDoctor method called..");
				DoctorDetails storedDoctore = doctorDao.save(doctor);
				storedDoctore.setDoctorId(doctorId+storedDoctore.getId());
				
				DoctorDetails doctorObject= doctorDao.save(storedDoctore);
				if(doctorObject==null)
					logger.trace("doctorObject is null ");
				return doctorObject;
			}
		
	@Override
	 public DoctorDetails updateDoctor(DoctorDetails doctor) {
//			DoctorDetails obj  = doctorDao.findByDoctorId(doctor.getDoctorId());
//		         obj.setFirstName(doctor.getFirstName());obj.setLastName(doctor.getLastName());
//		         obj.setAddress(doctor.getAddress()); obj.setAge(doctor.getAge());
//		         obj.setContactNumber(doctor.getContactNumber()); obj.setEmail(doctor.getEmail());
//		         obj.setFee(doctor.getFee()); obj.setQualification(doctor.getQualification());
//		         obj.setSpecialization(doctor.getSpecialization());
//		         
		logger.info("updateDoctor method started...");
		logger.info("updateDoctor  SucessFully executed....");
				return doctorDao.save(doctor);
			
			

		}	
	
		
		
		
	

	

	@Override
	public DoctorDetails getById(String doctorId) {

		
		return doctorDao.findByDoctorId(doctorId);
	}

	@Override
	public String deleteDoctor(Integer id) {
		
		List<Schedule> Sa=scheduleDao.getByDoctorId(id);
		if(Sa!=null) {
			scheduleDao.deleteAll(Sa);
		}
		
		
		doctorDao.deleteById(id);
		return "Record Deleted";
		
	}

	

}