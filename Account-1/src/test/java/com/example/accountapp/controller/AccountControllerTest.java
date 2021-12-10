package com.example.accountapp.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.accountapp.service.AccountService;

@DataJpaTest
@RunWith(MockitoJUnitRunner.class)
class AccountControllerTest {

	@Mock
	private AccountService accountService;
	
	private MockMvc mockMvc; 
	
	@Before
	public void setUp() throws Exception {
		//mockMvc = MockMvcBuilders.standaloneSetup(new OctusRestController(service)).build();
		mockMvc = MockMvcBuilders.standaloneSetup(new AccountController(accountService)).build();
	}
	
//	@Test
//	void postAccountTest() {
//		mockMvc.perform(post("/api/account/"))
//		
//	}
//	
	@Test
	public void getAllAccountTest() throws Exception{
		mockMvc.perform(get("/api/account/"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
