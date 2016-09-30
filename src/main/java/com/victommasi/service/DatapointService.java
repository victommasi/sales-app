package com.victommasi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victommasi.model.Datapoint;

@Service
public class DatapointService {
	
	@Autowired
	SaleService saleService;
	
	private static Map<Integer, String> monthMap = new HashMap<Integer, String>();
	
	public static void populateMap(){
		monthMap.put(1, "Janeiro");
		monthMap.put(2, "Fevereiro");
		monthMap.put(3, "Março");
		monthMap.put(4, "Abril");
		monthMap.put(5, "Maio");
		monthMap.put(6, "Junho");
		monthMap.put(7, "Julho");
		monthMap.put(8, "Agosto");
		monthMap.put(9, "Setembro");
		monthMap.put(10, "Outubro");	
		monthMap.put(11, "Novembro");
		monthMap.put(12, "Dezembro");
	}
	
	public List<Datapoint> getDatapoints(Integer year){
		List<Datapoint> datapoints = new ArrayList<Datapoint>();
		populateMap();
		
		//each month of year has its value
		for (int i = 1; i <= 12; i++){
			datapoints.add(new Datapoint(monthMap.get(i),
							   i, 
							   saleService.getMonthBalance(year, i)));
		}
		return datapoints;
	}
}
