package com.innoeye.hospitalmanagementsystem.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="room_allotement")
public class RoomAllotement implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="roomAllotement_Id")
	private Integer roomAllotementId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="room_no")
	private RoomDetails room;
	
	@ManyToOne
	@JoinColumn(name="patient_id")
	private PatientDetails patient;
	
	@Column(name="booked_date")
	private String bookedDate;
	
	@Column(name="discharge_date")
	private String dischargeDate;

	public Integer getRoomAllotementId() {
		return roomAllotementId;
	}

	public void setRoomAllotementId(Integer roomAllotementId) {
		this.roomAllotementId = roomAllotementId;
	}

	public RoomDetails getRoom() {
		return room;
	}

	public void setRoom(RoomDetails room) {
		this.room = room;
	}

	public PatientDetails getPatient() {
		return patient;
	}

	public void setPatient(PatientDetails patient) {
		this.patient = patient;
	}

	
	public String getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(String bookedDate) {
		this.bookedDate = bookedDate;
	}

	public String getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(String dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public RoomAllotement(Integer roomAllotementId, RoomDetails room, PatientDetails patient, Boolean isBooked,
			String bookedDate, String dischargeDate) {
		super();
		this.roomAllotementId = roomAllotementId;
		this.room = room;
		this.patient = patient;
		
		this.bookedDate = bookedDate;
		this.dischargeDate = dischargeDate;
	}

	public RoomAllotement() {
		super();
		// TODO Auto-generated constructor stub
	}
}
	
