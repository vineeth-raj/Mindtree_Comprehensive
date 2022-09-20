package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.entity.ErrorResponse;
import com.example.demo.exceptions.PatientIDNotFound;
import com.example.demo.exceptions.PatientIdAlreadyExists;

@ControllerAdvice
public class GlobalExceptionHander {
	
	@ExceptionHandler(value = PatientIdAlreadyExists.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public @ResponseBody ErrorResponse handleAlreadyExistsException(PatientIdAlreadyExists ex) {
		return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
	}
	
	
	
	@ExceptionHandler(value = PatientIDNotFound.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponse handleNotFoundException(PatientIDNotFound ex) {
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}
}
