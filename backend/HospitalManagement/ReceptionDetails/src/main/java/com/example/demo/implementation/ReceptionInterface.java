package com.example.demo.implementation;

import java.security.NoSuchAlgorithmException;

import com.example.demo.entity.Reception;

public interface ReceptionInterface {
	
	
	public Reception addReception(Reception admin) throws NoSuchAlgorithmException;
	
	public String checkReception(Reception admin) throws NoSuchAlgorithmException;
}
