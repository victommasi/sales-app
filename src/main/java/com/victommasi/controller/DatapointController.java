package com.victommasi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.victommasi.service.DatapointService;

@Controller
@RequestMapping("/datapoint")
public class DatapointController {
	
	@Autowired
	DatapointService datapointService;
	
	@ResponseBody
	@RequestMapping("/{year}")
	public ResponseEntity<?> getSaleBalanceByYear(@PathVariable("year") Integer year){
		return new ResponseEntity<>(datapointService.getDatapoints(year), HttpStatus.OK);
	}
	
}
