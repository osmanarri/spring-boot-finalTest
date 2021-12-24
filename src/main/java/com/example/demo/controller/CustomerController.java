package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@Controller
public class CustomerController {
	
	
	@Autowired
	CustomerService customerService;
	
	
	@GetMapping("/")
	public String displayForm(Model model) {
		
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		
		return "new-customer";
		
		
	}
	
	@PostMapping("/save")
	public String createCustomer(@Valid Customer customer,  BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			
			return "new-customer";
		}
		
		customerService.save(customer);
		
		model.addAttribute("customers", customerService.findAll());
		
		return "show";
		
	}
	
	@GetMapping("/customers")
	public String customers(Model model, Customer customer) {
		
		List<Customer> customers = customerService.findAll();
		
		model.addAttribute("customers", customers);
		
		
		
		return "show";
	}
	
	 @GetMapping("/delete/{id}")
	  public String deleteCustomerPage(@PathVariable(name = "id") long id) {
		 customerService.deleteById(id);
		 
	        return "redirect:/customers";
	        
	   }
	 
	 @GetMapping("/edit/{id}")
	    public ModelAndView showEditCustomerPage(@PathVariable(name = "id") long id) {
	        ModelAndView mav = new ModelAndView("new-customer");
	        Customer customer = customerService.get(id);
	        mav.addObject("customer", customer);
	        return mav;
	        
	    }
	 

	 
	 
	 @GetMapping("/count")
		
		public long countEntities() {
		 
			long count = customerService.count();
			
			return count;
		}
	
	

}
