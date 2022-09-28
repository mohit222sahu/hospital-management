package com.innoeye.hospitalmanagementsystem.controller.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.innoeye.hospitalmanagementsystem.controller.IRoomAllotementController;
import com.innoeye.hospitalmanagementsystem.model.RoomAllotement;
import com.innoeye.hospitalmanagementsystem.service.IRoomAllotementService;
@CrossOrigin
@RestController
public class RoomAllotementController implements IRoomAllotementController{
	private static final Logger logger = LoggerFactory.getLogger(RoomAllotementController.class);


	@Autowired
	IRoomAllotementService roomAllotementService;
	@Override
	public List<RoomAllotement> getAll() {
		logger.info("getting list of all  Allotement");
		return roomAllotementService.getAll();
	}

	@Override
	public RoomAllotement getByPatientId(Integer patientId) {
		logger.info("getting RoomAllotement by patient id "+patientId);
		return roomAllotementService.getByPatientId(patientId);
	}

	@Override
	public void addRoomAllotement(RoomAllotement roomAllotement) {
		logger.info("adding new  RoomAllotement");
		roomAllotementService.addRoomAllotement(roomAllotement);
		
	}

	@Override
	public RoomAllotement getByRoomNo(Integer roomNo) {
		logger.info("getting  RoomAllotement  by room number"+roomNo);
		return roomAllotementService.getByRoomNo(roomNo);
	}

	@Override
	public void deleteRoomAllotement(RoomAllotement roomAllotementId) {
		logger.info("deleting RoomAllotement Id : "+roomAllotementId);
		roomAllotementService.deleteRoomAllotement(roomAllotementId);
	}

	@Override
	public void updateRoomAllotement(RoomAllotement roomAllotement) {
		logger.info("updating RoomAllotement ");
		roomAllotementService.updateRoomAllotement(roomAllotement);
	}
	
	@Override
	public RoomAllotement findBypatient_id(Integer id) {
		logger.info("adding new  prescription");
		return roomAllotementService.findBypatient_id(id);
	}

}
