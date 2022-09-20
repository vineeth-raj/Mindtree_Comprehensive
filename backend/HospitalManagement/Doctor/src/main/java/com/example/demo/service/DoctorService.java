package com.example.demo.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.controller.AddResponse;
import com.example.demo.entity.Doctor;
import com.example.demo.exceptions.DoctorIDNotFound;
import com.example.demo.implementation.DoctorImpl;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.vo.DoctorVO;
import com.example.demo.vo.Patient;


@Service
@Component
public class DoctorService implements DoctorImpl {

	@Autowired
	DoctorRepository doctorRepository;
	
	
@Autowired
	RestTemplate restTemp; 
	@Override
	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		return doctorRepository.findAll();
	}

	@Override
	public Doctor getDoctorById(int id) {
		// TODO Auto-generated method stub
		return doctorRepository.findById(id).orElseThrow(() -> new DoctorIDNotFound("No Doctor Exists with that ID = "+id));
	}

	@Override
	public Doctor addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		int id = doctorRepository.findAll().size() + 1;
		doctor.setId(id);
		doctor.setNoofpatientsattended(0);
		doctor.setName("Dr. "+doctor.getName());
		doctorRepository.save(doctor);
		return doctor;
	}

	@Override
	public List<Doctor> addList(List<Doctor> doctors) {
		for(Doctor doctor: doctors)
		{
			doctor.setNoofpatientsattended(0);
			if(doctor.getGender().equalsIgnoreCase("Male"))
				doctor.setName("Mr. "+doctor.getName());
			else
				doctor.setName("Mrs. "+doctor.getName());
		}
		doctorRepository.saveAll(doctors);
		return doctors;
	}
	@Override
	public Doctor updateDoctor(int id, Doctor doctor) {
		// TODO Auto-generated method stub
		Doctor oldDoc = doctorRepository.findById(id).orElseThrow(() -> new DoctorIDNotFound("No Doctor Exists with that ID = "+id));
		oldDoc.setGender(doctor.getGender());
		oldDoc.setSpecfields(doctor.getSpecfields());
		oldDoc.setName(doctor.getName());
		oldDoc.setNoofpatientsattended(doctor.getNoofpatientsattended());
		oldDoc.setId(doctor.getId());
		oldDoc.setAge(doctor.getAge());
		doctorRepository.save(doctor);
		return doctor;
	}

	@Override
	public List<DoctorVO> PatientforParticulardoctor() {
		// TODO Auto-generated method stub
 List<DoctorVO> fulllist = this.getAllDoctors().stream().map(p -> {
			Doctor colg = p; 
			List<Patient> slist = Arrays.asList(restTemp.getForEntity("http://PATIENT-SERVICE/patient/doctor/" + p.getId(), Patient[].class).getBody());
			colg.setNoofpatientsattended(slist.size());
			return new DoctorVO(colg, slist);
		}).collect(Collectors.toList());
		return fulllist;	}

	@Override
	public List<DoctorVO> PatientforParticularResildoctor() {
		// TODO Auto-generated method stub
 List<DoctorVO> fulllist = this.getAllDoctors().stream().map(p -> {
			Doctor colg = p; 
			List<Patient> slist = null;
			return new DoctorVO(colg, slist);
		}).collect(Collectors.toList());
		return fulllist;	}

	@Override
	public AddResponse deleteDoctor(int id) {
		// TODO Auto-generated method stub
		doctorRepository.deleteById(id);
		AddResponse res = new AddResponse();
		res.setId(id);
		res.setMsg("Doctor Deleted...");
		return res;
	}

}