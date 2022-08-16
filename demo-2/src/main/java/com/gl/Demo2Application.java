package com.gl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gl.service.Calculator;

@SpringBootApplication
public class Demo2Application  implements CommandLineRunner{

	@Autowired
	private Calculator calc;
	
	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		float product1=calc.product(12, 34.56f);
		int product2=calc.product(65,100);
		System.out.println("Float : "+product1);
		System.out.println("Integer : "+product2);
		
	}

}
