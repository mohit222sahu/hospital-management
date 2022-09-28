package com.innoeye.hospitalmanagementsystem.service;

import java.util.List;

import com.innoeye.hospitalmanagementsystem.model.RoomDetails;

public interface IRoomService {

	public List<RoomDetails> getAll();
	
	public void deleteRoom(String roomId);

	public RoomDetails getByRoomNo(Integer roomId);

	public RoomDetails addRoom(RoomDetails room);

}

