package com.coderscampus.assignment13.web;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.assignment13.domain.Account;
import com.coderscampus.assignment13.domain.Address;
import com.coderscampus.assignment13.domain.User;
import com.coderscampus.assignment13.service.AccountService;
import com.coderscampus.assignment13.service.UserService;

@Controller
public class AccountController {

		@Autowired
		private UserService userService;
		
		@Autowired
		private AccountService accServ;
		
		@GetMapping("/users/{userId}/accounts/{accountId}")
		public String getAccount (ModelMap model, @PathVariable Long userId, @PathVariable Long accountId) {
			User user = userService.findById(userId);
			Account acc = accServ.findById(accountId);
	
			model.put("user", user);
			model.put("account", acc);
			return "accounts";
		}
		
		@PostMapping("/users/{userId}/accounts/{accountId}")
		public String saveAccount (Account acc, @PathVariable Long userId) {
			accServ.saveAccount(acc);
			return "redirect:/users/"+userId;
		}
		
		@PostMapping("/users/{userId}/accounts")
		public String createAccount (@PathVariable Long userId) {
			Account acc = new Account();
			User user = userService.findById(userId);
			
			acc.getUsers().add(user);
			user.getAccounts().add(acc);
			
			acc.setAccountName(user.getName() + " Investment Account");
			acc = accServ.saveAccount(acc);
			
			return "redirect:/users/"+userId+"/accounts/"+acc.getAccountId();
		}
	
}
