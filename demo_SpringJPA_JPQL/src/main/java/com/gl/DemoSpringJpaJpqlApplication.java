package com.gl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gl.services.CitizenService;

@SpringBootApplication
public class DemoSpringJpaJpqlApplication  implements CommandLineRunner
{
	@Autowired
	CitizenService service;
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringJpaJpqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Object[]> data=service.getNameAndDob();
		for(Object [] o:data)
		{
			System.out.println("Name : "+o[0]);
			System.out.println("Date Of Birth : "+o[1]);
		}
	}

}
