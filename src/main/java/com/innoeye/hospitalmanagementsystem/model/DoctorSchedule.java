package com.innoeye.hospitalmanagementsystem.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="doctor_schedule")
public class DoctorSchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="schedule_id")
    private Integer scheduleId;
	
	@ManyToOne
	@JoinColumn(name="doctor_id",referencedColumnName = "id")
	private DoctorDetails doctor;
	
	@Column(name="date")
    private Date date;
	
	@Column(name="time")
    private String time;
	 
	@Column(name="patient_name")
	private String patientName;

	public DoctorSchedule(Integer scheduleId, DoctorDetails doctor, Date date, String time, String patientName) {
		super();
		this.scheduleId = scheduleId;
		this.doctor = doctor;
		this.date = date;
		this.time = time;
		this.patientName = patientName;
	}

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public DoctorDetails getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorDetails doctor) {
		this.doctor = doctor;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	@Override
	public String toString() {
		return "DoctorSchedule [scheduleId=" + scheduleId + ", doctor=" + doctor + ", date=" + date + ", time=" + time
				+ ", patientName=" + patientName + "]";
	}

	public DoctorSchedule() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}