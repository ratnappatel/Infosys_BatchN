package com.gl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.gl.repository.UserRepository;
import com.gl.service.UserServiceImpl;

@SpringBootTest
class DemoMockitoApplicationTests {

	@Mock
	UserRepository repository;
	
	@InjectMocks
	UserServiceImpl service;
	
	@Test
	void findContactValidTest()
	{
		String name="Uttam";
		String mobileNo="7976694711";
		Mockito.when(repository.getMobileNo(name)).thenReturn(mobileNo);
		
		String actual=service.findContact(name);
		Assertions.assertEquals("Found", actual);
	}
	
	@Test
	void findContactInValidTest()
	{
		String name="Uttam";
		String mobileNo="7976694711";
		Mockito.when(repository.getMobileNo(name)).thenReturn(mobileNo);
		
		String actual=service.findContact("Ratna");
		Assertions.assertEquals("Not Found",actual);
	}
	
	
	@Test
	void contextLoads() {
	}

}
