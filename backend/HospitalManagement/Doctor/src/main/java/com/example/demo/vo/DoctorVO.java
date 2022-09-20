package com.example.demo.vo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.example.demo.entity.Doctor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class DoctorVO {

private Doctor doctor;
	private List<Patient> patient;	
	
}