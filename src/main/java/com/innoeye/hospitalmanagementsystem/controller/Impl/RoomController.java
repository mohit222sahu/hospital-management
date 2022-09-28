package com.innoeye.hospitalmanagementsystem.controller.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.innoeye.hospitalmanagementsystem.controller.IRoomController;
import com.innoeye.hospitalmanagementsystem.model.RoomDetails;
import com.innoeye.hospitalmanagementsystem.service.IRoomService;
@CrossOrigin
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
    public String addNote(String note, HttpServletRequest request) {
        //get the notes from request session
        List<String> notes = (List<String>) request.getSession().getAttribute("NOTES_SESSION");
        //check if notes is present in session or not
        System.out.println("notes = = = = "+notes);
        if (notes == null) {
            notes = new ArrayList<>();
            // if notes object is not present in session, set notes in the request session
            request.getSession().setAttribute("NOTES_SESSION", notes);
        }
        notes.add(note);
        request.getSession().setAttribute("NOTES_SESSION", notes);
        return "redirect:/getAll";
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
