package com.innoeye.hospitalmanagementsystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.innoeye.hospitalmanagementsystem.model.RoomAllotement;
import com.innoeye.hospitalmanagementsystem.model.RoomDetails;

import io.swagger.annotations.ApiOperation;


@RequestMapping(path="/room")
public interface IRoomController {

	@GetMapping(path="/getAll")
	@ApiOperation(value = "Get Room Details List",
	response = RoomDetails.class)
	public List<RoomDetails> getAll();
	
	@PostMapping(path="/addRoom")
	@ApiOperation(value = "Add Room Details",
	response = RoomDetails.class)
	public RoomDetails addRoom(@RequestBody RoomDetails room );
	
	@GetMapping(path="/deleteRoom/{roomId}")
	@ApiOperation(value = "Delete Room Details By Room Id")
	public void deleteRoom(@PathVariable String roomId);
	
	@GetMapping(path="/getRoomByNo/{roomId}")
	@ApiOperation(value = "Get Room Details By Room Id",
	response = RoomDetails.class)
	public RoomDetails getRoomByNo(@PathVariable Integer roomId);

	
}
