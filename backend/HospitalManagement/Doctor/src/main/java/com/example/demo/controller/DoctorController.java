package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.vo.DoctorVO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;import com.example.demo.entity.Doctor;
import com.example.demo.implementation.DoctorImpl;
import com.example.demo.service.DoctorService;

@CrossOrigin(origins="*", allowedHeaders = "*")@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	DoctorImpl docService;
	
private static final String RESILIENCEVALUE = "Doctor" ; 
	@GetMapping("/")
	public ResponseEntity<List<Doctor>> getAllDoctors()
	{
		List<Doctor> doctors = docService.getAllDoctors();
		return new ResponseEntity<List<Doctor>>(doctors, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Doctor> getDoctorByid(@PathVariable(value="id") int id)
	{
		Doctor doctor = docService.getDoctorById(id);
		return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);	}
	
	@PostMapping("/")
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor)
	{
		return new ResponseEntity<Doctor>(docService.addDoctor(doctor), HttpStatus.OK);
	}
	
@PostMapping("/bulk")
	public ResponseEntity<List<Doctor>> addBulk(@RequestBody List<Doctor> doctor){
//		try {
			 List<Doctor> doc=docService.addList(doctor);
			 return new ResponseEntity<List<Doctor>>(doc,HttpStatus.CREATED);
	}	@PutMapping("/{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable(value="id") int id, @RequestBody Doctor doctor)
	{
//		try {
			doctor = docService.updateDoctor(id, doctor);
			return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
	}
	
	@GetMapping("/doctor-patient/{id}")
 @CircuitBreaker(name=RESILIENCEVALUE, fallbackMethod = "getResilvalues")
	public ResponseEntity<?> PatientList(@PathVariable(value="id") int id){
		List<DoctorVO> col = docService.PatientforParticulardoctor();
		 return new ResponseEntity<List<DoctorVO>>(col,HttpStatus.OK);
	}
	public ResponseEntity<?> getResilvalues(@PathVariable(value="id") int id){
		List<DoctorVO> col = docService.PatientforParticularResildoctor();
		 return new ResponseEntity<List<DoctorVO>>(col,HttpStatus.OK);
	}
	@GetMapping("/deletedoctor/{id}")
	public void deleteDoctors(@PathVariable(value="id") int id)
	{
	}
	@DeleteMapping("/deletedoctor/{id}")
	public AddResponse deleteDoctor(@PathVariable(value="id") int id)
	{
		AddResponse res = docService.deleteDoctor(id);
		return res;
	}
}