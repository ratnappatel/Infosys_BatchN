package com.gl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gl.persistence.HelloAOP;

@SpringBootApplication
public class Demo1Application implements CommandLineRunner{

	@Autowired
	private HelloAOP aop;
	
	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	aop.printFibonacci();
	aop.printMessage("Great Learning");
		
	}

}
