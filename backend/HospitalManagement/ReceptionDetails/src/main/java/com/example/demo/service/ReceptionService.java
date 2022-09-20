package com.example.demo.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Reception;
import com.example.demo.implementation.ReceptionInterface;
import com.example.demo.repository.ReceptionRepository;


@Service
@Component
public class ReceptionService implements ReceptionInterface {
	
	
	@Autowired
	private ReceptionRepository receptionRepository;
	
	
	@Override
	public Reception addReception(Reception reception) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		byte[] salt = getSalt();
		int id = receptionRepository.findAll().size() + 1;
		reception.setId(id);
		reception.setPassword(getSecurePassword(reception.getPassword(), salt));
		reception.setSalt(salt);
		return receptionRepository.save(reception);
	}

	@Override
	public String checkReception(Reception reception) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		List<Reception> receptions = receptionRepository.findAll().stream()
				.collect(Collectors.toList());
		String user_password = reception.getPassword();
		System.out.println(user_password);
		for(Reception adm: receptions)
		{
			byte[] salt = adm.getSalt();
			if(salt!=null && getSecurePassword(user_password, salt).equals(adm.getPassword()))
				return "Right Password";
		}
		return "Wrong Password";
	}
	
	private String getSecurePassword(String password, byte[] salt) throws NoSuchAlgorithmException {
		String generatedPassword = null;
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(salt);
		byte[] bytes = md.digest(password.getBytes());
		StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        generatedPassword = sb.toString();
		return generatedPassword;
	}
	
	private static byte[] getSalt() {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		return salt;
	}

}
