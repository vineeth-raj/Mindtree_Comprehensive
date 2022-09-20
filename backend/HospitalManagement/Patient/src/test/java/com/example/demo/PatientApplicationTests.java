package com.example.demo;

import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.controller.PatientController;
import com.example.demo.entity.Patient;
import com.example.demo.entity.PatientWithFile;
import com.example.demo.service.PatientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes= {PatientApplicationTests.class})
class PatientApplicationTests {

@Mock
	private PatientService patientService;
	
	@InjectMocks
	private PatientController patientController; 
	
	
	List<Patient> patients;
	
	Patient patient;
	
	PatientWithFile patientWithFile;
	
	@Test
	@Order(1)
    public void getAllPatients(){
		patients = new ArrayList();
		patients.add(new Patient("22/22/2022", "Nothing stays hidden from me! Nothing", 1, "A", 1, 22, "D1", "male"));
		patients.add(new Patient("22/22/2022", "Nothing stays hidden from me! Nothing", 1, "A", 2, 22, "D1", "male"));
		patients.add(new Patient("22/22/2022", "Nothing stays hidden from me! Nothing", 1, "A", 3, 22, "D1", "male"));
		
		when(patientService.getAllPatients()).thenReturn(patients);
		ResponseEntity<List<Patient>> res = patientController.getAllPatients();
		
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(3, res.getBody().size());
    }
	
	
	@Test
	@Order(2)
	void getPatientById() {
		patients = new ArrayList<>();
		patient = new Patient("22/22/2022", "Nothing stays hidden from me! Nothing", 1, "A", 1, 22, "D1", "male");
		patients.add(patient);
		int id = 1;
		
		when(patientService.getPatientById(id)).thenReturn(patient);
		ResponseEntity<Patient> res = patientController.getPatientByid(id);
		
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(id, res.getBody().getId());
		
		
	}
	
	@Test
	@Order(3)
	void getPatientByDocId() {
		patient = new Patient("22/22/2022", "Nothing stays hidden from me! Nothing", 1, "A", 1, 22, "D1", "male");
		int dept_id = 1;
		
		when(patientService.getByDoctorId(dept_id)).thenReturn(Arrays.asList(patient));
		ResponseEntity<List<Patient>> res = patientController.getPatientBydoctor(dept_id);
		
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(dept_id, res.getBody().get(0).getDoctorid());
		
	}
	
	@Test
	@Order(4)
	void addPatient() throws JsonMappingException, JsonProcessingException
	{
		patient = new Patient("22/22/2022", "Nothing stays hidden from me! Nothing", 1, "A", 1, 22, "D1", "male");
		MultipartFile file = new MultipartFile() {
			
			@Override
			public void transferTo(File dest) throws IOException, IllegalStateException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public long getSize() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public String getOriginalFilename() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public InputStream getInputStream() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getContentType() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public byte[] getBytes() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
		};
		when(patientService.addPatient(file, patient)).thenReturn(patient);
		patientWithFile = new PatientWithFile(patient, file);
		//ResponseEntity<Patient> res = patientController.addPatient(file, "patient");
		
		
		//assertEquals(HttpStatus.OK, res.getStatusCode());
		//assertEquals(patient, res.getBody());
	}
	
	
	@Test
	@Order(5)
	void updateAgent() {
		patient = new Patient("22/22/2022", "Nothing stays hidden from me! Nothing", 1, "A", 1, 22, "D1", "male");
		int id = 1;
		
		when(patientService.getPatientById(id)).thenReturn(patient);
		when(patientService.updatePatient(id, patient)).thenReturn(patient);
		ResponseEntity<Patient> res = patientController.updatePatient(id, patient);
		
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(id, res.getBody().getId());
		assertEquals("A", res.getBody().getName());
	}
	
	

}
