package com.innoeye.hospitalmanagementsystem.controller.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.innoeye.hospitalmanagementsystem.controller.IDoctorScheduleController;
import com.innoeye.hospitalmanagementsystem.model.DoctorSchedule;
import com.innoeye.hospitalmanagementsystem.model.Schedule;
import com.innoeye.hospitalmanagementsystem.service.IDoctorScheduleService;
@CrossOrigin
@RestController
public class DoctorScheduleController implements IDoctorScheduleController{
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(DoctorScheduleController.class);

@Autowired
IDoctorScheduleService doctorScheduleService;
	
@Override
	public List<DoctorSchedule> getAll(Integer id) {
	   logger.info("getting All doctors schedule");
		return doctorScheduleService.getAll(id);
	}

	
	@Override
	public void addSchedule(@RequestBody List<DoctorSchedule> doctorSchedule) {
		   logger.info("creating a doctors schedule");
		doctorScheduleService.addSchedule(doctorSchedule);
	}


	@Override
	public List<Schedule> getByDoctorId(Integer id) {
		   logger.info("getting  a doctors schedule by doctor id : "+id);
		return doctorScheduleService.getByDoctorId(id);
	}


	
}
