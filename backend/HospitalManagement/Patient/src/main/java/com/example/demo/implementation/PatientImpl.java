package com.example.demo.implementation;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.controller.AddResponse;
import com.example.demo.entity.Patient;

public interface PatientImpl {
	
	public List<Patient> getAllPatients();
	
	public Patient getPatientById(int id);
	

public List<Patient> getByDoctorId(int doctor);

	public Patient addPatient(MultipartFile file, Patient patient);
	
public List<Patient> addList(List<Patient> patient);
	public Patient updatePatient(int id, Patient Patient);
	
	public AddResponse deletePatient(int id);
}
