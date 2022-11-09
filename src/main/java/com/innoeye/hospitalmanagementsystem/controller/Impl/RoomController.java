package com.innoeye.hospitalmanagementsystem.controller.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innoeye.hospitalmanagementsystem.controller.IRoomController;
import com.innoeye.hospitalmanagementsystem.model.RoomDetails;
import com.innoeye.hospitalmanagementsystem.service.IRoomService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

public class RoomController implements IRoomController {
	private static final Logger logger = LoggerFactory.getLogger(PrescriptionController.class);

	@Autowired
	IRoomService roomService;
	@Override
	public List<RoomDetails> getAll(){
		logger.info("getting list of rooms ");
		return roomService.getAll();
	
}

	@Override
	public RoomDetails addRoom(RoomDetails room) {
		logger.info("adding new  room");
		return roomService.addRoom(room);
	}

	@Override
	public void deleteRoom(String roomId) {
		logger.info("deleting  room number :"+roomId);
		roomService.deleteRoom(roomId);
	}

	@Override
	public RoomDetails getRoomByNo(Integer roomId) {
		logger.info("getting room details by room number "+roomId);
		return roomService.getByRoomNo(roomId);
	}}
