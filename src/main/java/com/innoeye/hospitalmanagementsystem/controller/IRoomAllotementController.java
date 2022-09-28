package com.innoeye.hospitalmanagementsystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innoeye.hospitalmanagementsystem.model.PrescriptionDetails;
import com.innoeye.hospitalmanagementsystem.model.RoomAllotement;

import io.swagger.annotations.ApiOperation;



@RequestMapping(path="/roomAllotement")
public interface IRoomAllotementController {
	
	@GetMapping("/getAll")
	@ApiOperation(value = "Get Room Allotement List",
	response = RoomAllotement.class)
	public List<RoomAllotement> getAll();
	
	@GetMapping("/getByPatientId/{patientId}")
	@ApiOperation(value = "Get Room Allotement By  Id",
	response = RoomAllotement.class)
	public  RoomAllotement getByPatientId(@PathVariable Integer patientId);
	
	@PostMapping("/addRoomAllotement")
	@ApiOperation(value = "Add Room Allotement",
	response = RoomAllotement.class)
	public void addRoomAllotement(@RequestBody RoomAllotement roomAllotement);
	
	@GetMapping("/getByRoomNo/{roomNo}")
	@ApiOperation(value = "Get Room Allotement By Room Number",
	response = RoomAllotement.class)
	public  RoomAllotement getByRoomNo(@PathVariable Integer roomNo);
	
	@PostMapping("/delete")
	@ApiOperation(value = "Detele Room Allotement")
	public void deleteRoomAllotement(@RequestBody RoomAllotement roomAllotementId);
	
	@PostMapping("/update")
	@ApiOperation(value = "Update Room Allotement")
	public void updateRoomAllotement(@RequestBody RoomAllotement roomAllotement);
	
	@GetMapping("/findByPatientId/{id}")
	@ApiOperation(value = "Find Room Allotement By Patient ID",
	response = RoomAllotement.class)
	public  RoomAllotement  findBypatient_id(@PathVariable Integer id);
}
