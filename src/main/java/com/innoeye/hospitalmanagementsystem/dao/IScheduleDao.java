package com.innoeye.hospitalmanagementsystem.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.innoeye.hospitalmanagementsystem.model.DoctorDetails;
import com.innoeye.hospitalmanagementsystem.model.PatientDetails;
import com.innoeye.hospitalmanagementsystem.model.Schedule;

@Repository
public interface IScheduleDao extends JpaRepository<Schedule, String> {
	
	@Query("SELECT s FROM Schedule s WHERE s.scheduleId = :id")
	Schedule findByScheduleId(@Param("id") String scheduleId);
	
	 @Transactional
	  @Modifying
	@Query("DELETE  FROM Schedule s WHERE s.scheduleId = :id")
	void deleteByScheduleId(@Param("id") String scheduleId);

	List<Schedule> getByDoctorId(Integer id);

	Schedule findBypatient_id(@Param("id") Integer id);
	
	
	 @Query(value="select * from schedule  order by schedule_id desc",nativeQuery=true)
	    List<Schedule> findAll();
	 
	 
	 @Query(value="select * from schedule  where patient_id=?1",nativeQuery=true)
	    List<Schedule> findAllByPatientId(Integer id);

	@Query(value="select patient from Schedule s where s.doctor.firstName LIKE :name%")
	    List<PatientDetails> filterByAttendeeDoctor(@Param("name")String name);
    
	@Query(value="select patient from Schedule s where s.date=:date")
	    List<PatientDetails> filterByAdmissionDate(@Param("date")Date date);
	 
}
