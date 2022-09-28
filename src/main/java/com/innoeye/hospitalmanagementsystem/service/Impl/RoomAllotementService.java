package com.innoeye.hospitalmanagementsystem.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innoeye.hospitalmanagementsystem.dao.IRoomAllotementDao;
import com.innoeye.hospitalmanagementsystem.dao.IRoomDao;
import com.innoeye.hospitalmanagementsystem.model.RoomAllotement;
import com.innoeye.hospitalmanagementsystem.service.IRoomAllotementService;
@Service
public class RoomAllotementService implements IRoomAllotementService {
	
	Logger logger = LoggerFactory.getLogger(RoomAllotementService.class);

@Autowired
IRoomAllotementDao roomAllotementDAO;
@Autowired
IRoomDao roomDAO;
	@Override
	public List<RoomAllotement> getAll() {
		logger.info("getAll method called..");
		
		
		logger.info("getAll method called sucefull");
		return roomAllotementDAO.findAll();
	}

	@Override
	public RoomAllotement getByPatientId(Integer patientId) {
logger.info("getByPatientid method called");
   logger.info("patient id : "+patientId);
return roomAllotementDAO.findByPatientId(patientId);
	}

	@Override
	public void addRoomAllotement(RoomAllotement roomAllotement) {
		logger.info("AddRoomAllotement  method called");
		
		roomAllotementDAO.save(roomAllotement);
		roomDAO.save(roomAllotement.getRoom());	}

	@Override
	public RoomAllotement getByRoomNo(Integer roomNo) {
		logger.info("findByRoomNo   method called");
		
		logger.info(" roomAllotement fatched  roomNo : "+roomNo);
		return roomAllotementDAO.findByRoomNo(roomNo);
	}

	@Override
	public void deleteRoomAllotement(RoomAllotement roomAllotementId) {
		logger.info("deleteRoomAllotement method called ");
		
		logger.info(" roomAllotement deleted   tId : "+roomAllotementId);

		roomDAO.findByRoomNo(roomAllotementId.getRoom().getRoomNo()).setIsBooked(false);
		
		roomAllotementDAO.delete(roomAllotementId);
		}

	@Override
	public void updateRoomAllotement(RoomAllotement roomAllotement) {
		logger.info("updateRoomAlllotement method called ..");	
		
		logger.info("roomAllotement updated sucessfull called ..");		
		
		roomDAO.findByRoomNo(roomAllotement.getRoom().getRoomNo()).setIsBooked(false);
				
		roomAllotementDAO.save(roomAllotement);
		
	}
	
	
	@Override
	public RoomAllotement findBypatient_id(Integer id) {
		// TODO Auto-generated method stub
		return roomAllotementDAO.findBypatient_id(id);
	}

	
}
