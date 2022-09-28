package com.innoeye.hospitalmanagementsystem.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.innoeye.hospitalmanagementsystem.model.DoctorDetails;
import com.innoeye.hospitalmanagementsystem.model.RoomAllotement;
@Repository
public interface IRoomAllotementDao extends JpaRepository<RoomAllotement,Integer>{

	RoomAllotement findByPatientId(Integer patientId);
    
	@Query(value="select * from room_allotement where room_room_no=?1",nativeQuery = true)
	RoomAllotement findByRoomNo(Integer roomNo);
	
	public RoomAllotement findBypatient_id(@Param("id") Integer id);
	
	@Query(value="select * from room_allotement order by room_allotement_id desc",nativeQuery=true)
    List<RoomAllotement> findAll();

}