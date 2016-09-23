package com.victommasi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.victommasi.repository.CustomerRepository;

@Controller
@RequestMapping("/customer")
public class CustomerFilterController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping("/negociating")
	public String getCustomersByStatusNegociating(Model model) {
		model.addAttribute("customers", customerRepository.findByStatusNegociating());
		return "/customer/customer_list";
	}

	@RequestMapping("/accepted")
	public String getCustomersByStatusAccepted(Model model) {
		model.addAttribute("customers", customerRepository.findByStatusAccepted());
		return "/customer/customer_list";
	}
	
	@RequestMapping("/refused")
	public String getCustomersByStatusRefused(Model model) {
		model.addAttribute("customers", customerRepository.findByStatusRefused());
		return "/customer/customer_list";
	}
}
	