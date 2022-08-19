package de.meicook.smallBanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.meicook.smallBanking.model.Account;
import de.meicook.smallBanking.service.BankingService;

@RestController
public class BankingController {

	@Autowired
	BankingService bankingService;
	
	@PostMapping("/addAccount")  
	private String saveStudent(@RequestBody Account account)   
	{  
		return bankingService.saveOrUpdate(account); 
	} 
	
	@PutMapping("/depositMoney")  
	private String depositMoney(@RequestParam(name = "account_id") Long id, @RequestParam Long amount)   
	{  
		return bankingService.depositMoney( id, amount);  
	}
	
	@PutMapping("/withdrawMoney")  
	private String withdrawMoney(@RequestParam(name = "account_id") Long id, @RequestParam Long amount)   
	{  
		return bankingService.withdrawMoney( id, amount);  
	}
}
