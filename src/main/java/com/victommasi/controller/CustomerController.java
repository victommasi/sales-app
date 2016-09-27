package com.victommasi.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.victommasi.model.Customer;
import com.victommasi.model.Status;
import com.victommasi.repository.CustomerRepository;
import com.victommasi.service.CustomerService;
import com.victommasi.service.EmailService;
import com.victommasi.wrapper.EmailWrapper;
import com.victommasi.wrapper.SmsWrapper;


@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping
	public ModelAndView getAllCustomers() {
		ModelAndView mv = new ModelAndView("/customer/customer_list");
		mv.addObject("customers", customerRepository.findAll());
		return mv;
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public ModelAndView findByNameOrPhone(Customer customer){
		ModelAndView mv = new ModelAndView("/customer/customer_list");
		mv.addObject("customers", customerRepository.findByNameOrPhone(customer));
		return mv;
	}
	
	@RequestMapping("/new")
	public ModelAndView createCustomer(Customer customer) {
		ModelAndView mv = new ModelAndView("/customer/customer_creation");
		mv.addObject("status", Status.values());
		return mv;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView createCustomer(@Valid Customer customer, 
									   BindingResult result, 
									   RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return createCustomer(customer);
		}
		
		customerService.saveCustomer(customer);
		attributes.addFlashAttribute("message", "Cliente salvo com sucesso!");
		return new ModelAndView("redirect:/customer/new");
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") Integer id){
		customerService.deleteCustomer(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping("/{id}")
	public ModelAndView showCustomer(@PathVariable("id") Customer customer) {
		ModelAndView mv = new ModelAndView("/customer/customer_edition");
		mv.addObject("status", Status.values());
		mv.addObject("customer", customer);
		return mv;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ModelAndView updateCustomer(@Valid Customer customer, 
									   BindingResult result, 
									   RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return showCustomer(customer);
		}
		
		customerService.saveCustomer(customer);
		attributes.addFlashAttribute("message", "Cliente atualizado com sucesso!");
		return new ModelAndView("redirect:/customer");
	}
	
	@ResponseBody
	@RequestMapping("/name/{id}")
	public String getCustomerName(@PathVariable("id") Integer id){
		Customer customer = customerRepository.findOne(id);
		String name = customer.getName();
		return name;
	}
	
	@RequestMapping(value = "/email", method = RequestMethod.POST)
	public ResponseEntity<?> exportToEmail(@RequestBody EmailWrapper emailWrapper){
		emailService.exportToEmail(emailWrapper);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
	