package com.innoeye.hospitalmanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.innoeye.hospitalmanagementsystem.model.DoctorDetails;
import com.innoeye.hospitalmanagementsystem.model.PatientDetails;

public interface IPatientDao extends JpaRepository<PatientDetails,Integer> {
	
	
	@Query(value="select * from patient_details order by patient_id_pk desc",nativeQuery=true)
    List<PatientDetails> findAll();

	@Query(value="select * from patient_details where patient_first_name  LIKE :name% OR city LIKE :name% OR gender LIKE :name% OR patient_last_name LIKE :name%",nativeQuery=true)
		List<PatientDetails> filterByName(@Param("name")String name);
}
