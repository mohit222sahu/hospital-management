package com.innoeye.hospitalmanagementsystem.service.Impl;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innoeye.hospitalmanagementsystem.dao.IDoctorScheduleDAO;
import com.innoeye.hospitalmanagementsystem.dao.IPatientDao;
import com.innoeye.hospitalmanagementsystem.dao.IScheduleDao;
import com.innoeye.hospitalmanagementsystem.model.DoctorSchedule;
import com.innoeye.hospitalmanagementsystem.model.PatientDetails;
import com.innoeye.hospitalmanagementsystem.model.Schedule;
import com.innoeye.hospitalmanagementsystem.service.IScheduleService;

@Service
public class ScheduleService implements IScheduleService {
	
	Logger logger = LoggerFactory.getLogger(ScheduleService.class);

	@Autowired
	IPatientDao patientDao;
	@Autowired
	 private IScheduleDao scheduleDao;
    @Autowired
    private IDoctorScheduleDAO doctorScheduleDAO;
	@Override
	public Schedule addSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
	DoctorSchedule d =	doctorScheduleDAO.getById(schedule.getMyId());
	PatientDetails pt=patientDao.getById(schedule.getPatient().getId());
	String patientName=pt.getFirst_name()+" "+pt.getLast_name();
    d.setPatientName(patientName);
    System.out.println(patientName);
	return scheduleDao.save(schedule);
	}

	@Override
	public List<Schedule> getAll() {
	    logger.info("getAll method  called ..");		
		
			logger.info("getAll sucessfully executed...");			
			return scheduleDao.findAll();
	}

	
	@Override
	public void deleteSchedule(String scheduleId) {
		  logger.info("deleteSchedule method  called ..");		
     	logger.info("deleteSchedule sucessfully executed...");		
			scheduleDao.deleteByScheduleId(scheduleId);
	}

	@Override
	public Schedule getById(String scheduleId) {
		// TODO Auto-generated method stub
		//System.out.println("byid");
		//System.out.println(scheduleDao.findByScheduleId(scheduleId));
		 logger.info("getById method  called ..");		
	     	logger.info("getById sucessfully executed...");
		
		return scheduleDao.findByScheduleId(scheduleId);
	}

	@Override
	public List<Schedule> getByDoctorId(Integer id) {
		logger.info("getByDoctorId method  called ..");		
     	logger.info("getByDoctorId sucessfully executed...");
     	
     	return scheduleDao.getByDoctorId(id);
	}
	@Override
	public Schedule getByPatientId(Integer id) {
		logger.info("getByPatientId method  called ..");		
     	logger.info("getByPatientId sucessfully executed...");
		return scheduleDao.findBypatient_id(id);
	}

	@Override
	public List <PatientDetails> filterByAttendeeDoctor(String name) {
		logger.info("filterByAttendeeDoctor method  called ..");		
     	logger.info("filterByAttendeeDoctor sucessfully executed...");		
     	return scheduleDao.filterByAttendeeDoctor(name);
	}

	@Override
	public List<PatientDetails> filterByAdmissionDate(Date date) {

		logger.info("filterByAdmissionDate method  called ..");		
     	logger.info("filterByAdmissionDate sucessfully executed...");
		return scheduleDao.filterByAdmissionDate(date);
	}
}
