package com.innoeye.hospitalmanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.innoeye.hospitalmanagementsystem.model.DoctorSchedule;
import com.innoeye.hospitalmanagementsystem.model.Schedule;
@Repository
public interface IDoctorScheduleDAO extends JpaRepository<DoctorSchedule,Integer> {
 
//	DoctorSchedule findById(Integer id);
	
	@Query(value="select * from doctor_schedule where doctor_id=?1 order by date asc,time asc",nativeQuery = true)
	List<DoctorSchedule> findAll(Integer id);

	List<Schedule> getByDoctorId(Integer id);
}
