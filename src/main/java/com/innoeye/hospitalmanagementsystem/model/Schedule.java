package com.innoeye.hospitalmanagementsystem.model;
import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="schedule")
public class Schedule implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="schedule_id")
	private Integer scheduleId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="patient_id")
	private PatientDetails patient;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="doctor_id")
	private DoctorDetails doctor;
	
	@Column(name="schedule_date")
	private String date;

	@Column(name="slot_time")
	private String time;
	
	@Column(name="myId")
	private Integer myId;

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public PatientDetails getPatient() {
		return patient;
	}

	public void setPatient(PatientDetails patient) {
		this.patient = patient;
	}

	public DoctorDetails getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorDetails doctor) {
		this.doctor = doctor;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getMyId() {
		return myId;
	}

	public void setMyId(Integer myId) {
		this.myId = myId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Schedule(Integer scheduleId, PatientDetails patient, DoctorDetails doctor, String date, String time,
			Integer myId) {
		super();
		this.scheduleId = scheduleId;
		this.patient = patient;
		this.doctor = doctor;
		this.date = date;
		this.time = time;
		this.myId = myId;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", patient=" + patient + ", doctor=" + doctor + ", date=" + date
				+ ", time=" + time + ", myId=" + myId + "]";
	}

	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
