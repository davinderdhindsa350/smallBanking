package de.meicook.smallBanking.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import de.meicook.smallBanking.model.Account;

public interface BankingRepository extends CrudRepository<Account, Long> {
	
	@Modifying
	@Query("update Account ac set ac.balance = ?1 where ac.id = ?2")
	int updateBalance(Long amount, Long id);

}
