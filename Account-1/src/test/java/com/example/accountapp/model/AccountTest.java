package com.example.accountapp.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Test;
import org.mockito.internal.junit.JUnitTestRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.accountapp.model.Account;

@Category(JUnitTestRule.class)
@DataJpaTest
class AccountTest {
	
	@Autowired
	private Account account;
	
	//private Holding holding;
	
	//private List<Holding> holdingList;
	
	private long id = 1;
	
	private String accountName = "Name" ;
	
	private String profileId = "Id";
	
	private int totalBalance = 999;
	
//	@Before
//	public void setUp() throws Exception {
//		Account account= new Account();
//	//Holding holding = new Holding();
//		account.setId(1);
//		account.setAccountName("Name");
//		account.setProfileId("Id");
//		account.setTotalBalance(999);
//	//	holdingList = new ArrayList<>();
//	//	holdingList.add(holding);
//		
//	}
	

	@Test
	void testaccount() {
		
		Account account = Account.builder()
				.id(1)
				.accountName("name")
				.profileId("Id")
				.totalBalance(999)
				.build();
		
		Assertions.assertThat(account.getId()).isEqualTo(id);

//		assertEquals(1, account.getId());
//		assertEquals("name", account.getAccountName());
//		assertEquals(account.getProfileId(), "Id");
//		assertEquals(totalBalance, account.getTotalBalance());
//		//assertEquals(holdingList, account.getHolding());
	}

}
