package com.example.demo.implementation;

import java.security.NoSuchAlgorithmException;

import com.example.demo.entity.Admin;

public interface AdminInterface {
	
	
	public Admin addAdmin(Admin admin) throws NoSuchAlgorithmException;
	
	public String checkAdmin(Admin admin) throws NoSuchAlgorithmException;
}
