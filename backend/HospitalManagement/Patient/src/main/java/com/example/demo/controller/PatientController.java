package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Patient;
import com.example.demo.entity.PatientWithFile;
import com.example.demo.implementation.PatientImpl;
import com.example.demo.service.PatientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins="*", allowedHeaders = "*")@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	PatientImpl patService;
	
	@GetMapping("/")
	public ResponseEntity<List<Patient>> getAllPatients()
	{
		List<Patient> patients = patService.getAllPatients();
		return new ResponseEntity<List<Patient>>(patients, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Patient> getPatientByid(@PathVariable(value="id") int id)
	{
		Patient patient = patService.getPatientById(id);
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);	}
	
	@PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE }, value="/")
	public ResponseEntity<?> addPatient(@RequestParam("file") MultipartFile file, @RequestParam("patient") String pat) throws JsonMappingException, JsonProcessingException
	{
		Patient patient = new ObjectMapper().readValue(pat, Patient.class);
		return new ResponseEntity<Patient>(patService.addPatient(file, patient),HttpStatus.OK);
	}
	
@PostMapping("/bulk")
	public ResponseEntity<List<Patient>> addBulk(@RequestBody List<Patient> patient){
//		try {
			 List<Patient> pat=patService.addList(patient);
			 return new ResponseEntity<List<Patient>>(pat,HttpStatus.CREATED);
	}	@PutMapping("/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable(value="id") int id, @RequestBody Patient patient)
	{
//		try {
			patient = patService.updatePatient(id, patient);
			return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public AddResponse deletePatient(@PathVariable(value="id") int id)
	{
		AddResponse res = patService.deletePatient(id);
		return res;
	}

@GetMapping("doctor/{id}")
	public ResponseEntity<List<Patient>> getPatientBydoctor(@PathVariable(value="id")int id){

		try {
			List<Patient> list = patService.getByDoctorId(id);
			return new ResponseEntity<List<Patient>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}