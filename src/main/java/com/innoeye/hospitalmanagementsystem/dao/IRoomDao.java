package com.innoeye.hospitalmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.innoeye.hospitalmanagementsystem.model.RoomDetails;
@Repository
public interface IRoomDao extends JpaRepository<RoomDetails,String> {

	//List<DoctorDetails> deleteById(String doctorId);

    RoomDetails findByRoomNo(Integer roomId);
}

