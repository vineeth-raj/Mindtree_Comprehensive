package com.example.demo.implementation;

import java.util.List;

import com.example.demo.controller.AddResponse;
import com.example.demo.entity.Doctor;

import com.example.demo.vo.DoctorVO;

public interface DoctorImpl {
	
	public List<Doctor> getAllDoctors();
	
	public Doctor getDoctorById(int id);
	
	public Doctor addDoctor(Doctor doctor);
	
public List<Doctor> addList(List<Doctor> doctor);
	public Doctor updateDoctor(int id, Doctor Doctor);
	
 public List<DoctorVO> PatientforParticulardoctor(); 
 public List<DoctorVO> PatientforParticularResildoctor(); 
	public AddResponse deleteDoctor(int id);
}
