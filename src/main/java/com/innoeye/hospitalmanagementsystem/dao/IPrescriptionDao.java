package com.innoeye.hospitalmanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.innoeye.hospitalmanagementsystem.model.PrescriptionDetails;
@Repository
public interface IPrescriptionDao extends JpaRepository<PrescriptionDetails,String> {

	//List<DoctorDetails> deleteById(String doctorId);

//    PrescriptionDetails findByPrescriptionId(String prescriptionId);
    
    public  List<PrescriptionDetails>  findBypatient_id(@Param("id") Integer id);
}