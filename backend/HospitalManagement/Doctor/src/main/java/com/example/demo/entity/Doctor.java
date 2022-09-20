package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table(name="Doctor")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Doctor {

private String gender;
	

private String specfields;
	

private String name;
	

private int noofpatientsattended;
	

@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

private int age;
	

	
	
}