package com.innoeye.hospitalmanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.innoeye.hospitalmanagementsystem.model.DoctorDetails;
@Repository
public interface IDoctorDao extends JpaRepository<DoctorDetails,Integer> {

	void deleteById(Integer id);

    DoctorDetails findByDoctorId(String doctorId);
    @Query(value="select * from doctor_details order by id desc",nativeQuery=true)
    List<DoctorDetails> findAll();
}
