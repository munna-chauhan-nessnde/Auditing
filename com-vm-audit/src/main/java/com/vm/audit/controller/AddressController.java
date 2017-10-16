package com.vm.audit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vm.audit.domain.Address;
import com.vm.audit.repository.AddressRepository;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

	@Autowired
	private AddressRepository repository;
	
	@PostMapping
	public String addReservation(@RequestBody Address address){
		repository.save(address);
		return "Success";
	}
}
