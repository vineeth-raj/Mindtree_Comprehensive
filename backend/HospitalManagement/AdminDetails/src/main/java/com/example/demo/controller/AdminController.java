package com.example.demo.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Admin;
import com.example.demo.implementation.AdminInterface;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	
	@Autowired
	AdminInterface adminService;
	
	@PostMapping("/")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) throws NoSuchAlgorithmException
	{
		return new ResponseEntity<Admin>(adminService.addAdmin(admin), HttpStatus.OK);
	}
	
	@PostMapping("/check-admin")
	public ResponseEntity<String> checkAdmin(@RequestBody Admin admin) throws NoSuchAlgorithmException
	{
		return new ResponseEntity<String>(adminService.checkAdmin(admin), HttpStatus.OK);
	}
}
