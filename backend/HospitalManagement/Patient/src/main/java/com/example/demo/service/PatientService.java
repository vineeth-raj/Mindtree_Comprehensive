package com.example.demo.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.controller.AddResponse;
import com.example.demo.entity.Patient;
import com.example.demo.exceptions.PatientIDNotFound;
import com.example.demo.implementation.PatientImpl;
import com.example.demo.repository.PatientRepository;


@Service
@Component
public class PatientService implements PatientImpl {

	@Autowired
	PatientRepository patientRepository;
	
	
	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return patientRepository.findAll();
	}

	@Override
	public Patient getPatientById(int id) {
		// TODO Auto-generated method stub
		return patientRepository.findById(id).orElseThrow(() -> new PatientIDNotFound("No Patient Exists with ID = "+id));
	}


   @Override

public List<Patient> getByDoctorId(int doctorid){

	   List<Patient> patient = patientRepository.findAll();
		for (Patient s : patient) {
			if (s.getDoctorid() == doctorid) {
				return (List<Patient>) s;
			}
		}
		return null;}
	@Override
	public Patient addPatient(MultipartFile file, Patient patient) {
		// TODO Auto-generated method stub
		int id = patientRepository.findAll().size() + 1;
		patient.setId(id);
		patient.setPrescription(AddFile(file));
		if (patient.getGender().equalsIgnoreCase("male"))
			patient.setName("Mr. "+patient.getName());
		else
			patient.setName("Mrs. "+patient.getName());
		patientRepository.save(patient);
		return patient;
	}
@Override
	public List<Patient> addList(List<Patient> patient) {
		patientRepository.saveAll(patient);
		return patient;
	}
	@Override
	public Patient updatePatient(int id, Patient patient) {
		// TODO Auto-generated method stub
		Patient oldPat = patientRepository.findById(id).orElseThrow(() -> new PatientIDNotFound("No Patient Exists with ID = "+id));
		oldPat.setDateofvisit(patient.getDateofvisit());
		oldPat.setPrescription(patient.getPrescription());
		oldPat.setDoctorid(patient.getDoctorid());
		oldPat.setName(patient.getName());
		oldPat.setId(patient.getId());
		oldPat.setAge(patient.getAge());
		oldPat.setVisiteddoctorname(patient.getVisiteddoctorname());
		patientRepository.save(patient);
		return patient;
	}

	@Override
	public AddResponse deletePatient(int id) {
		// TODO Auto-generated method stub
		patientRepository.deleteById(id);
		AddResponse res = new AddResponse();
		res.setId(id);
		res.setMsg("Patient Deleted...");
		return res;
	}

	private String AddFile(MultipartFile file){
		// TODO Auto-generated method stub
		try {
			File convertedFile = new File(file.getOriginalFilename());
			convertedFile.createNewFile();
			FileOutputStream fout = new FileOutputStream(convertedFile);
			fout.write(file.getBytes());
			BufferedReader br = new BufferedReader(new FileReader(convertedFile));
			String st;
			String st_tot = "";
			while((st=br.readLine())!=null)
				st_tot += st;
			return st_tot;
		}
		catch (Exception e) {
			// TODO: handle exception
			return "File Not Found";
		}
	}
	
	
	

}