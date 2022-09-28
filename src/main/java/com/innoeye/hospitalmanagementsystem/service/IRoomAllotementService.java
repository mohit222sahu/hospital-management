package com.innoeye.hospitalmanagementsystem.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.innoeye.hospitalmanagementsystem.model.RoomAllotement;

public interface IRoomAllotementService {
public List<RoomAllotement> getAll();
public RoomAllotement getByPatientId(Integer patientId);
public RoomAllotement getByRoomNo(Integer roomNo);
public void addRoomAllotement(RoomAllotement roomAllotement);
public void deleteRoomAllotement(RoomAllotement roomAllotementId);
public void updateRoomAllotement(RoomAllotement roomAllotement);
public  RoomAllotement  findBypatient_id(@PathVariable Integer id);
}
