package com.innoeye.hospitalmanagementsystem.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innoeye.hospitalmanagementsystem.model.PatientDetails;
import com.innoeye.hospitalmanagementsystem.model.RoomDetails;
import com.innoeye.hospitalmanagementsystem.model.Schedule;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/appointment")
public interface IScheduleController {

	@PostMapping("/addschedule")
	@ApiOperation(value = "Add Appointment",
	response = Schedule.class)
	public Schedule addSchedule(@RequestBody Schedule schedule);

	@DeleteMapping("/delete/{scheduleId}")
	@ApiOperation(value = "Detele Appointment By Id")
	public void deleteSchedule(@PathVariable String scheduleId);

	@GetMapping("/getbyid/{scheduleId}")
	@ApiOperation(value = "Get Appointment By Id",
	response = Schedule.class)
	public Schedule getScheduleById(@PathVariable  String scheduleId);
	
	@GetMapping("/get")
	@ApiOperation(value = "Get Appointment List",
	response = Schedule.class)
	public List<Schedule> getAll();

   @GetMapping("/getByDoctorId/{id}")
   @ApiOperation(value = "Get Appointment List By Doctor Id",
	response = Schedule.class)
   public List<Schedule> getByDoctorId(@PathVariable Integer id);

   @GetMapping("/getByPatientId/{id}")
   @ApiOperation(value = "Get Appointment  By Patient Id",
	response = Schedule.class)
   public Schedule getByPatientId(@PathVariable  Integer id);

   @GetMapping("/filterByAttendeeDoctor/{name}")
   @ApiOperation(value = "Filter Appointment List By Doctor Name",
	response = Schedule.class)
   public List<PatientDetails> filterByAttendeeDoctor(@PathVariable String name);

   @GetMapping("/filterByAdmissionDate/{date}")
   public List<PatientDetails> filterByAdmission(@PathVariable Date date);
}


