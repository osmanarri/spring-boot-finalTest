package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	public List<Customer> findAll(){
		
		return customerRepository.findAll();		
		
	}
	public void save (Customer customer){
		
		customerRepository.save(customer);		
		
	}
	public Customer get (long id){
	
	return customerRepository.findById(id).get();		
	
	}
	public void deleteById (long id){
	
		customerRepository.deleteById(id);		
	
	}		

	
	 public long count() {
         return customerRepository.count();
     }


}
