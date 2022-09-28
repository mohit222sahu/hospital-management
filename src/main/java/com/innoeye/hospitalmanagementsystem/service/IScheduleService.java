package com.innoeye.hospitalmanagementsystem.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.innoeye.hospitalmanagementsystem.model.PatientDetails;
import com.innoeye.hospitalmanagementsystem.model.Schedule;


public interface IScheduleService {

	public Schedule addSchedule(Schedule schedule);

	public List<Schedule> getAll();


	public Schedule getById(String scheduleId);

	public void deleteSchedule(String scheduleId);

	public List<Schedule> getByDoctorId(Integer id);

	public Schedule getByPatientId(Integer id);

	public List<PatientDetails> filterByAttendeeDoctor(String name);

	public List<PatientDetails> filterByAdmissionDate(Date date);

}
