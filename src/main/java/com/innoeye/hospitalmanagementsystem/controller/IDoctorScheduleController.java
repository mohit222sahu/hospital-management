package com.innoeye.hospitalmanagementsystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.innoeye.hospitalmanagementsystem.model.DoctorDetails;
import com.innoeye.hospitalmanagementsystem.model.DoctorSchedule;
import com.innoeye.hospitalmanagementsystem.model.Schedule;

import io.swagger.annotations.ApiOperation;

@RequestMapping("/doctorSchedule")
public interface IDoctorScheduleController {

@GetMapping("/getAll/{id}")
public List<DoctorSchedule> getAll(@PathVariable Integer id);
//
//@PostMapping("/addSchedule")
//public DoctorSchedule addSchedule(DoctorSchedule doctorSchedule);

@PostMapping("/addSchedule")
@ApiOperation(value = "Add Doctor Schedule ",
response = DoctorSchedule.class)
public void addSchedule(List<DoctorSchedule> doctorSchedule);


@GetMapping("getByDoctorId")
@ApiOperation(value = "Get Doctor Schedule by Doctor Id ",
response = DoctorSchedule.class)
public List<Schedule> getByDoctorId(@PathVariable Integer id);
}