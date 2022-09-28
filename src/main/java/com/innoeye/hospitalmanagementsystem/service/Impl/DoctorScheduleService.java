package com.innoeye.hospitalmanagementsystem.service.Impl;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innoeye.hospitalmanagementsystem.dao.IDoctorScheduleDAO;
import com.innoeye.hospitalmanagementsystem.model.DoctorSchedule;
import com.innoeye.hospitalmanagementsystem.model.Schedule;
import com.innoeye.hospitalmanagementsystem.service.IDoctorScheduleService;
@Service
public class DoctorScheduleService implements IDoctorScheduleService {
	
	private static final Logger logger = LoggerFactory.getLogger(DoctorService.class);

@Autowired
IDoctorScheduleDAO doctorScheduleDAO;
	@Override
	public List<DoctorSchedule> getAll(Integer id) {
		logger.info("getAll method started...");
		logger.info("getAll  SucessFully executed....");
		return doctorScheduleDAO.findAll(id);
	}


	@Override
	public void addSchedule(List<DoctorSchedule> doctorSchedule) {
		logger.info("addSchedule method started...");
		logger.info("addSchedule  SucessFully executed....");
		doctorScheduleDAO.saveAll(doctorSchedule);
	}


	@Override
	public List<Schedule> getByDoctorId(Integer id) {
		logger.info("getByDoctorId method started...");
		logger.info("getByDoctorId  SucessFully executed....");
		return doctorScheduleDAO.getByDoctorId(id);
	}



	

	
}
