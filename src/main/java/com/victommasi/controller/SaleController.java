package com.victommasi.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.victommasi.dto.CustomObjectDTO;
import com.victommasi.model.Balance;
import com.victommasi.model.Customer;
import com.victommasi.model.Sale;
import com.victommasi.repository.CustomerRepository;
import com.victommasi.repository.SaleRepository;
import com.victommasi.service.SaleService;

@Controller
@RequestMapping("/sale")
public class SaleController {
	
	@Autowired
	SaleService saleService;
	
	@Autowired
	SaleRepository saleRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@RequestMapping
	public ModelAndView getAllSales(){
		ModelAndView mv = new ModelAndView("sale/sale_list");
		mv.addObject("sales", saleRepository.findAll());
		return mv;
	}
	
	@RequestMapping("/find")
	public ModelAndView getSaleByCustomerNameOrPhone(Sale sale, Customer customer){
		ModelAndView mv = new ModelAndView("/sale/sale_list");
		sale.setCustomer(customer);
		mv.addObject("sales", saleRepository.findSaleByNameOrPhone(sale));
		return mv;
	}
	
	@RequestMapping("/find/{id}")
	public ResponseEntity<?> getSaleByCustomerId(@PathVariable("id") Integer id){
		return new ResponseEntity<>(saleRepository.checkSaleByCustomerId(id), HttpStatus.OK);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
	public ModelAndView createSale(@PathVariable("customerId") Customer customer, Sale sale) {
		ModelAndView mv = new ModelAndView("/sale/sale_creation");
		mv.addObject("customer", customer);
		return mv;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView createSale(Customer customer, @Valid Sale sale, 
													BindingResult errors, 
													RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return createSale(customer, sale);
		}
		attributes.addFlashAttribute("message", "Venda salva com sucesso!");
		saleService.saveSale(new CustomObjectDTO(customer, sale));
		return new ModelAndView("redirect:/sale");
	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
	public ModelAndView deleteSale(@PathVariable Integer id, RedirectAttributes attributes){
		saleService.deleteSale(id);
		attributes.addFlashAttribute("message", "Venda excluída com sucesso!");
		return new ModelAndView("redirect:/sale");
	}
	
	@RequestMapping("/balance")
	public String getSaleBalance(Model model, Balance balance){
		model.addAttribute("balance", saleService.getTotalBalance(balance));
		return "/sale/sale_balance";
	}
	
	@ResponseBody
	@RequestMapping("/year/{year}")
	public ResponseEntity<?> getSaleBalanceByYear(@PathVariable("year") Integer year){
		return new ResponseEntity<>(saleService.getYearBalance(year), HttpStatus.OK);
	}
	
}
