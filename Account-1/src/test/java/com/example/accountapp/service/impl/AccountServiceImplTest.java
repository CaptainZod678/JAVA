package com.example.accountapp.service.impl;



import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.example.accountapp.model.Account;
import com.example.accountapp.repository.AccountRepository;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountServiceImplTest {
	
	@Autowired
	private AccountRepository mockaccountRepository;

	@Test
	@Order(1)
	@Rollback(value = false)
	void saveAccountTest() {
		Account account = Account.builder()
				.accountName("name")
				.profileId("id")
				.totalBalance(999)
				.build();
	
		mockaccountRepository.save(account);
		
		Assertions.assertThat(account.getId()).isGreaterThan(0);
	}
	
	@Test
	@Order(2)
	void getAccountByIdTest() {
		Account account = mockaccountRepository.getById(1L) ;
		
		Assertions.assertThat(account.getId()).isEqualTo(1L);
	}
	
	@Test
	@Order(3)
	void getAllAccountTest() {
		
		List<Account> account = mockaccountRepository.findAll();
		Assertions.assertThat(account.size()).isGreaterThan(0);
	}
	
	@Test
	@Order(4)
	@Rollback(value = false)
	void updateAccountTest() {
		
		Account account = mockaccountRepository.getById(1L);
		
		account.setAccountName("Zod");
		Account accountUpdate = mockaccountRepository.save(account);
		
		Assertions.assertThat(accountUpdate.getAccountName()).isEqualTo("Zod");
	}
	
	@Test
	@Order(5)
	@Rollback(value = false)
	void deleteAccountTest() {
		
		Account account = mockaccountRepository.getById(1L);
		mockaccountRepository.delete(account);
		
		Account account1 = null;
		Optional<Account> optionalAccount = mockaccountRepository.findById(1L);
		
		if(optionalAccount.isPresent()) {
			account1 = optionalAccount.get();
		}
		
	  Assertions.assertThat(account1).isNull();
	}


}
