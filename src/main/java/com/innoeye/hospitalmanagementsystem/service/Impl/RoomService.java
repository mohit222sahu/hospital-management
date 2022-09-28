package com.innoeye.hospitalmanagementsystem.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innoeye.hospitalmanagementsystem.dao.IRoomDao;
import com.innoeye.hospitalmanagementsystem.model.RoomDetails;
import com.innoeye.hospitalmanagementsystem.service.IRoomService;

@Service
public class RoomService implements IRoomService {

	@Autowired
	IRoomDao roomDao;

	@Override
	public List<RoomDetails> getAll() {

		return roomDao.findAll();
	}

	@Override
	public RoomDetails addRoom(RoomDetails room) {
		return roomDao.save(room);

	}

	@Override
	public void deleteRoom(String roomId) {

		//roomDao.delete(roomDao.findByRoomId(roomId));
	}

	@Override
	public RoomDetails getByRoomNo(Integer roomId) {

		return roomDao.findByRoomNo(roomId);
	}

}
