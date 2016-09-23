package com.victommasi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.victommasi.Wrapper.ObjectWrapper;
import com.victommasi.model.Customer;
import com.victommasi.model.Sale;
import com.victommasi.repository.CustomerRepository;
import com.victommasi.repository.SaleRepository;
import com.victommasi.service.CustomerService;
import com.victommasi.service.SaleService;

@Controller
@RequestMapping("/sale")
public class SaleController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	SaleService saleService;
	
	@Autowired
	SaleRepository saleRepository;
	
	@RequestMapping
	public ModelAndView getAllSales(){
		ModelAndView mv = new ModelAndView("sale/sale_list");
		mv.addObject("sales", saleRepository.findAll());
		return mv;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ResponseEntity<?> createSale(@RequestBody ObjectWrapper objectWrapper) {
		
		customerService.updateCustomer(objectWrapper);
		saleService.saveSale(objectWrapper);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
	public ModelAndView deleteSale(@PathVariable Integer id, RedirectAttributes attributes){
		
		saleService.deleteSale(id);
		attributes.addFlashAttribute("message", "Venda excluída com sucesso!");
		return new ModelAndView("redirect:/sale");
	}
}
