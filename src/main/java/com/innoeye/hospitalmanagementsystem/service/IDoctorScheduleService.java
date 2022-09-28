package com.innoeye.hospitalmanagementsystem.service;

import java.util.List;

import com.innoeye.hospitalmanagementsystem.model.DoctorSchedule;
import com.innoeye.hospitalmanagementsystem.model.Schedule;

public interface IDoctorScheduleService {
public void addSchedule(List<DoctorSchedule> doctorSchedule);
public List<DoctorSchedule> getAll(Integer id);
public List<Schedule> getByDoctorId(Integer id);
}
