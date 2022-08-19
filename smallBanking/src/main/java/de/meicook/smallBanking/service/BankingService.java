package de.meicook.smallBanking.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.meicook.smallBanking.model.Account;
import de.meicook.smallBanking.repository.BankingRepository;

@Service
public class BankingService {

	@Autowired
	BankingRepository bankingRepository;
	
	public String saveOrUpdate(Account account) {
		
		try {
		if(account.getId() != null && bankingRepository.existsById(account.getId()))
			return "Account already exits";
		else
			return "New account is created with Account id :"+bankingRepository.save(account).getId();
		} catch(Exception e) {
			return "Error Please try again "+e.getMessage();
		}
		
	}

	@Transactional
	public String depositMoney(Long id, Long amount) {
		
		try {
			Optional<Account> account=bankingRepository.findById(id);
			if(account.isPresent()) {
				Long newBalance=account.get().getBalance()+amount;
				return bankingRepository.updateBalance(newBalance, id)==1?"Now Account balance is "+newBalance:"Not able to deposit ammount due to internal erroe please try again";
			} else
				return "Account number is incorrect!";
			} catch(Exception e) {
				return "Error Please try again "+e.getMessage();
			}
	}

	@Transactional
	public String withdrawMoney(Long id, Long amount) {
		try {
			Optional<Account> account=bankingRepository.findById(id);
			if(account.isPresent()) {
				Long newBalance=account.get().getBalance()-amount;
				if(newBalance<0)
					return "Account have insufficient balance to debit , Account balance is "+account.get().getBalance()+" after withdrawing "+amount+" it will in negative";
				return bankingRepository.updateBalance(newBalance, id)==1?"Now Account balance is "+newBalance:"Not able to credit ammount due to internal erroe please try again";
			} else
				return "Account number is incorrect!";
			} catch(Exception e) {
				return "Error Please try again "+e.getMessage();
			}
	}

}
