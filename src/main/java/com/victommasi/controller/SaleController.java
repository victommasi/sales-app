package com.victommasi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.victommasi.model.Customer;
import com.victommasi.model.Sale;
import com.victommasi.repository.CustomerRepository;
import com.victommasi.repository.SaleRepository;
import com.victommasi.service.CustomerService;
import com.victommasi.service.SaleService;
import com.victommasi.wrapper.ObjectWrapper;

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
	
	@RequestMapping("/find")
	public ModelAndView getSaleByCustomerNameOrPhone(Customer customer){
		ModelAndView mv = new ModelAndView("/sale/sale_list");
		Sale sale = new Sale();
		sale.setCustomer(customer);
		mv.addObject("sales", saleRepository.findByNameOrPhone(sale));
		return mv;
	}
	
	@RequestMapping("/find/{id}")
	public ResponseEntity<?> getSaleByCustomerId(@PathVariable("id") Integer id){
		return new ResponseEntity<>(saleRepository.findById(id), HttpStatus.OK);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView createSale(@RequestBody ObjectWrapper objectWrapper) {
		customerService.updateCustomer(objectWrapper);
		saleService.saveSale(objectWrapper);
		return new ModelAndView("redirect:/customer");
	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
	public ModelAndView deleteSale(@PathVariable Integer id, RedirectAttributes attributes){
		
		saleService.deleteSale(id);
		attributes.addFlashAttribute("message", "Venda excluída com sucesso!");
		return new ModelAndView("redirect:/sale");
	}
}
