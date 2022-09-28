package com.innoeye.hospitalmanagementsystem.model;


import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prescription_details")
public class PrescriptionDetails {
	
	
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Id
//    private Integer id;
//	
//	@Column(name = "prescriptionId")
//	private String prescriptionId;
//	
//	@Column(name = "p_id")
//	private Integer patient_id;
//
//	
//	@Column(name = "prescription_type")
//	private String prescription_type;
//	
//	@Column(name = "types")
//	private String types;
//	
//	@Column(name = "schedule")
//	private String schedule;
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getPrescription_type() {
//		return prescription_type;
//	}
//
//	public void setPrescription_type(String prescription_type) {
//		this.prescription_type = prescription_type;
//	}
//
//	public String getTypes() {
//		return types;
//	}
//
//	public void setTypes(String types) {
//		this.types = types;
//	}
//
//	public String getSchedule() {
//		return schedule;
//	}
//
//	public void setSchedule(String schedule) {
//		this.schedule = schedule;
//	}
//	
//	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

		
		
//		@Column(name="prescriptionId")
//		private Integer prescriptionId;
//		
		//change to mapping
		@Column(name="prescription_type")
		private String prescription_type;
		
		@Column(name="types")
		private String types;
		
		//change to mapping
		@Column(name="schedule")
		private String schedule;
        @ManyToOne
        @JoinColumn(name="doctor_id")
		private DoctorDetails doctor;
        @ManyToOne
        @JoinColumn(name="patient_id")
		private PatientDetails patient;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
//		public Integer getPrescriptionId() {
//			return prescriptionId;
//		}
//		public void setPrescriptionId(Integer prescriptionId) {
//			this.prescriptionId = prescriptionId;
//		}
		public String getPrescription_type() {
			return prescription_type;
		}
		public void setPrescription_type(String prescription_type) {
			this.prescription_type = prescription_type;
		}
		public String getTypes() {
			return types;
		}
		public void setTypes(String types) {
			this.types = types;
		}
		public String getSchedule() {
			return schedule;
		}
		public void setSchedule(String schedule) {
			this.schedule = schedule;
		}
		public DoctorDetails getDoctor() {
			return doctor;
		}
		public void setDoctor(DoctorDetails doctor) {
			this.doctor = doctor;
		}
		public PatientDetails getPatient() {
			return patient;
		}
		public void setPatient(PatientDetails patient) {
			this.patient = patient;
		}
		public PrescriptionDetails(Integer id, String prescription_type, String types,
				String schedule, DoctorDetails doctor, PatientDetails patient) {
			super();
			this.id = id;
			
			this.prescription_type = prescription_type;
			this.types = types;
			this.schedule = schedule;
			this.doctor = doctor;
			this.patient = patient;
		}
		public PrescriptionDetails() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "PrescriptionDetails [id=" + id  + ", prescription_type="
					+ prescription_type + ", types=" + types + ", schedule=" + schedule + ", doctor=" + doctor
					+ ", patient=" + patient + "]";
		}
        
		
}



//