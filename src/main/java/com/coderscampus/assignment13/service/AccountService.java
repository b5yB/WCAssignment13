package com.coderscampus.assignment13.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment13.domain.Account;
import com.coderscampus.assignment13.domain.User;
import com.coderscampus.assignment13.repository.AccountRepository;
import com.coderscampus.assignment13.repository.UserRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accRepo;
	
	public Account saveAccount(Account acc) {
		
		return accRepo.save(acc);
	}
	
	public Account findById(Long accId) {
		Optional<Account> accOpt = accRepo.findById(accId);
		
		return accOpt.orElse(new Account());
	}

}
