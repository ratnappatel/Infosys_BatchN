package com.gl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gl.service.Calculator;

@SpringBootTest
class Demo2ApplicationTests {

	@Autowired
	public Calculator calc;
	
	@Test
	void testProductFloatValid()
	{
		float actual=calc.product(10, 10.50f);
		Assertions.assertEquals(105.0, actual);
	}
	
	@Test
	void testProductFloatNotValid()
	{
		float actual=calc.product(10, 10.50f);
		Assertions.assertEquals(155.0, actual);
	}
	
	
	@Test
	void contextLoads() {
	}

}
