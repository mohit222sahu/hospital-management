package com.innoeye.hospitalmanagementsystem.controller.Impl;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.innoeye.hospitalmanagementsystem.controller.IScheduleController;
import com.innoeye.hospitalmanagementsystem.model.PatientDetails;
import com.innoeye.hospitalmanagementsystem.model.Schedule;
import com.innoeye.hospitalmanagementsystem.service.IScheduleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ScheduleController implements IScheduleController {

	private static final Logger logger = LoggerFactory.getLogger(RoomAllotementController.class);

	
	@Autowired
	private IScheduleService scheduleService;
	
	
	@Override
	public List<Schedule> getAll(){
		logger.info("getting list of schedules ");
		return scheduleService.getAll();
	}

	
	@Override
	public Schedule addSchedule(Schedule schedule) {
		logger.info("adding  new schedule ");

		return scheduleService.addSchedule(schedule);
		
	}

	@Override
	public void deleteSchedule(String scheduleId) {
		logger.info("deletig schedule  "+scheduleId);
		scheduleService.deleteSchedule(scheduleId);
	}

	
	@Override
	public Schedule getScheduleById(String scheduleId) {
		logger.info("getting  schedule by id :   "+scheduleId);
		return scheduleService.getById(scheduleId);
	}
	
	@Override
	public List<Schedule> getByDoctorId(Integer id) {
		logger.info("getting list of  doctors schedules by doctor id : "+id);
		return scheduleService.getByDoctorId(id);
	}
	
	@Override
	public Schedule getByPatientId(Integer id) {
		logger.info("getting list of  doctors schedules by patient id : "+id);
		return scheduleService.getByPatientId(id);
	}


	@Override
	public List <PatientDetails> filterByAttendeeDoctor(String name) {
		logger.info("getting list of  Patients  by attendee doctor : "+name);
		return scheduleService.filterByAttendeeDoctor(name);
	}


	@Override
	public List<PatientDetails> filterByAdmission(Date date) {
		logger.info("getting list of  Patients  by admision date  : "+date);
		return scheduleService.filterByAdmissionDate(date);
	}
	
}
	


