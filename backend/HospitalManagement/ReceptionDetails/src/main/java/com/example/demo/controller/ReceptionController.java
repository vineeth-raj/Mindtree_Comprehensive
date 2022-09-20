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

import com.example.demo.entity.Reception;
import com.example.demo.implementation.ReceptionInterface;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/reception")
public class ReceptionController {
	
	
	@Autowired
	ReceptionInterface receptionService;
	
	@PostMapping("/")
	public ResponseEntity<Reception> addReception(@RequestBody Reception reception) throws NoSuchAlgorithmException
	{
		return new ResponseEntity<Reception>(receptionService.addReception(reception), HttpStatus.OK);
	}
	
	@PostMapping("/check-reception")
	public ResponseEntity<String> checkReception(@RequestBody Reception reception) throws NoSuchAlgorithmException
	{
		return new ResponseEntity<String>(receptionService.checkReception(reception), HttpStatus.OK);
	}
}
