//package com.innoeye.hospitalmanagementsystem.service.Impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.innoeye.hospitalmanagementsystem.dao.IDoctorScheduleDAO;
//import com.innoeye.hospitalmanagementsystem.dao.IPatientDao;
//import com.innoeye.hospitalmanagementsystem.dao.IRoomAllotementDao;
//import com.innoeye.hospitalmanagementsystem.dao.IRoomDao;
//import com.innoeye.hospitalmanagementsystem.dao.IScheduleDao;
//import com.innoeye.hospitalmanagementsystem.entity.PatientDetails;
//import com.innoeye.hospitalmanagementsystem.entity.RoomAllotement;
//import com.innoeye.hospitalmanagementsystem.entity.RoomDetails;
//import com.innoeye.hospitalmanagementsystem.entity.Schedule;
//import com.innoeye.hospitalmanagementsystem.service.IPatientService;
//
//@Service
//public class PatientService implements IPatientService{
//	
//	@Autowired
//	IPatientDao pr;
//	@Autowired
//    IRoomAllotementDao roomAllotementDAO;
//	@Autowired
//	IRoomDao roomDAO;
//	@Autowired
//	IScheduleDao scheduleDao;
//	@Autowired
//	IDoctorScheduleDAO doctorScheduleDao;
//	@Override
//	public PatientDetails addPatient(PatientDetails patient) {
//		
//	return pr.save(patient);
//				
//	}
//
//	@Override
//	public List<PatientDetails> patientList() {
//				return pr.findAll();
//	}
//
//	@Override
//	public PatientDetails getById(Integer id) {
//		return pr.getById(id);
//	}
//
//	@Override
//	public void deletePatient(Integer id) {
//		
//	RoomAllotement rA=roomAllotementDAO.findByPatientId(id);
//		if(rA!=null){
//	    RoomDetails room=rA.getRoom();
//		room.setIs_booked(false);
//		roomAllotementDAO.delete(rA);
//		}
//		List<Schedule> Sa=scheduleDao.findAllByPatientId(id);
//		if(Sa!=null) {
//			scheduleDao.deleteAll(Sa);
//			for(int i=0;i<Sa.size();i++)
//			{
//				doctorScheduleDao.deleteById(Sa.get(i).getMyId());
//			}
//		}
//		pr.delete(pr.getById(id));
//		}
//
//	@Override
//	public void updatePatient(PatientDetails patient) {
//		pr.save(patient);
//	}
//
//	@Override
//	public List<PatientDetails> filterByName(String name) {
//		// TODO Auto-generated method stub
//		return pr.filterByName(name);
//	}
//
//}

package com.innoeye.hospitalmanagementsystem.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innoeye.hospitalmanagementsystem.dao.IPatientDao;
import com.innoeye.hospitalmanagementsystem.service.IPatientService;
import com.innoeye.hospitalmanagementsystem.util.HospitalConstants;
import com.innoeye.hospitalmanagementsystem.exceptions.ResourceNotFoundException;
import com.innoeye.hospitalmanagementsystem.model.PatientDetails;
import com.innoeye.hospitalmanagementsystem.exceptions.BadRequestException;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PatientService implements IPatientService{

	@Autowired
	IPatientDao pr;
	Logger logger = LoggerFactory.getLogger(PatientService.class);

	@Transactional
	@Override
	public ResponseEntity<PatientDetails> addPatient(PatientDetails patient) {

		logger.info("addPatient method started...");
		logger.info("Patient added SucessFully....");
		return new ResponseEntity<PatientDetails>(pr.save(patient), HttpStatus.CREATED);

	}

	@Override
	public ResponseEntity<List<PatientDetails>> patientList() {
		
		logger.info("patien patientList method called ");
		List<PatientDetails> patient = pr.findAll();
		if (patient.size() == 0)
			throw new ResourceNotFoundException("No Patient records available");
		return new ResponseEntity<>(patient, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<PatientDetails> getById(Integer id) {
		logger.info("get by Id  method called...");
		if (id < 0)
			throw new BadRequestException("Patient id  Should not be negative....");
		if (pr.existsById(id)) {
			return new ResponseEntity<PatientDetails>(pr.findById(id).get(), HttpStatus.OK);
		}
		logger.error(HospitalConstants.PATIENT_RECORDS_NOT_FOUND);
		throw new ResourceNotFoundException(HospitalConstants.ID_NOT_FOUND + ":" + id);

	}

	@Override
	public ResponseEntity<HttpStatus> deletePatient(Integer id) {
		logger.info("deletePatient method called.....");
		if (pr.existsById(id)) {
			pr.delete(pr.getById(id));
		logger.info("Patient deleted  sucessfully  id :" + id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		throw new ResourceNotFoundException(HospitalConstants.ID_NOT_FOUND + ":" + id);
}

	@Override
	public ResponseEntity<HttpStatus> updatePatient(PatientDetails patient) {
		logger.info("updatePatient method called....");
		pr.save(patient);
		
		logger.info("patient updated sucessfully ");
		return new ResponseEntity<>(HttpStatus.OK);
}



}
