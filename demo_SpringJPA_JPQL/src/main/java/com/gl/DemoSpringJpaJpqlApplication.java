package com.gl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gl.dto.CitizenDTO;
import com.gl.exception.CitizenException;
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
		//this.getNameAndDob();
		//this.getNameEndWith();
		//this.getCitizenByBirthYear();
		//this.getCitizenByGender();
		this.updateAddress();
	}
	
	public void getNameEndWith()
	{
		List<String> names=service.getNameEndsWith("%Patel");
		for(String name:names)
			System.out.println(name);
	}
	public void getNameAndDob()
	{
		List<Object[]> data=service.getNameAndDob();
		for(Object [] o:data)
		{
			System.out.println("Name : "+o[0]);
			System.out.println("Date Of Birth : "+o[1]);
		}
	}

	public void getCitizenByBirthYear()
	{
		List<CitizenDTO> citizens=
		service.getCitizensByDobBetween(LocalDate.of(1977, 1, 1), LocalDate.of(2000, 1, 1));
		
		System.out.println(citizens);
	}
	public void getCitizenByGender()
	{
		String gender="Female";
		long n=service.getCitizenByGender(gender);
		System.out.println("There are "+n+" "+gender+" Citizens are there");
	}
	
	public void updateAddress()
	{
		int id=1105;
		String address="New Address";
		String msg="";
		try 
		{
			msg = service.updateCitizenAddress(id, address);
		} catch (CitizenException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(msg);
	}
}
