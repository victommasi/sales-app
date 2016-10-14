package com.victommasi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.victommasi.dto.EmailDTO;
import com.victommasi.service.EmailService;

@Controller
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	@RequestMapping(value = "/email", method = RequestMethod.POST)
	public ResponseEntity<?> exportToEmail(@RequestBody EmailDTO emailDto){
		emailService.exportToEmail(emailDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
