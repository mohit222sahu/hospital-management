package com.innoeye.hospitalmanagementsystem.service;



import java.util.List;

import com.innoeye.hospitalmanagementsystem.model.PrescriptionDetails;

public interface IPrescriptionService {

	public List<PrescriptionDetails> getAll();
	
//	public void deletePrescription(String prescriptionId);
//
//	public PrescriptionDetails getById(String prescriptionId);

	public List<PrescriptionDetails> addPrescription(List<PrescriptionDetails> prescriptionList);
	public List<PrescriptionDetails> getByPatientId(Integer id);
	

}

