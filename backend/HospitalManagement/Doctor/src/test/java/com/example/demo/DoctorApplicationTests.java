package com.example.demo;

import static org.mockito.Mockito.when;

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
import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.controller.DoctorController;
import com.example.demo.entity.Doctor;
import com.example.demo.service.DoctorService;
import com.example.demo.vo.DoctorVO;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes= {DoctorApplicationTests.class})
class DoctorApplicationTests {

@Mock
	private DoctorService doctorService;
	
	@InjectMocks
	private DoctorController doctorController; 
	
	
	List<Doctor> doctors;
	
	Doctor doctor;
	
	List<DoctorVO> doctorVOs;
	
	@Test
	@Order(1)
    public void getAllDoctors(){
		doctors = new ArrayList();
		doctors.add(new Doctor("male", "ASD", "A", 2, 1, 22));
		doctors.add(new Doctor("male", "ASD", "A", 2, 2, 22));
		doctors.add(new Doctor("male", "ASD", "A", 2, 3, 22));
		
		when(doctorService.getAllDoctors()).thenReturn(doctors);
		ResponseEntity<List<Doctor>> res = doctorController.getAllDoctors();
		
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(3, res.getBody().size());
    }
	
	
	@Test
	@Order(2)
	void getDoctorById() {
		doctors = new ArrayList<>();
		doctor = new Doctor("male", "ASD", "A", 2, 1, 22);
		doctors.add(doctor);
		int id = 1;
		
		when(doctorService.getDoctorById(id)).thenReturn(doctor);
		ResponseEntity<Doctor> res = doctorController.getDoctorByid(id);
		
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(id, res.getBody().getId());
		
		
	}
	
	@Test
	@Order(3)
	void getDoctorByPatId() {
		doctor = new Doctor("male", "ASD", "A", 2, 1, 22);
		int dept_id = 1;
		
		when(doctorService.PatientforParticulardoctor()).thenReturn(doctorVOs);
		ResponseEntity<?> res = doctorController.PatientList(dept_id);
		
		assertEquals(HttpStatus.OK, res.getStatusCode());		
	}
	
	@Test
	@Order(4)
	void addDoctor()
	{
		doctor = new Doctor("male", "ASD", "A", 2, 1, 22);
		
		when(doctorService.addDoctor(doctor)).thenReturn(doctor);
		ResponseEntity<Doctor> res = doctorController.addDoctor(doctor);
		
		assertEquals(doctor, res.getBody());
	}
	
	
	@Test
	@Order(5)
	void updateAgent() {
		doctor = new Doctor("male", "ASD", "A", 2, 1, 22);
		int id = 1;
		
		when(doctorService.getDoctorById(id)).thenReturn(doctor);
		when(doctorService.updateDoctor(id, doctor)).thenReturn(doctor);
		ResponseEntity<Doctor> res = doctorController.updateDoctor(id, doctor);
		
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(id, res.getBody().getId());
		assertEquals("A", res.getBody().getName());
	}
	
	

}