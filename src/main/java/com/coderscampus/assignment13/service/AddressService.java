package com.coderscampus.assignment13.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment13.domain.Address;
import com.coderscampus.assignment13.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addRepo;
	
	public Address saveAddress (Address add) {
		return addRepo.save(add);
	}
	
	
}
