package com.gl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gl.dto.CitizenDTO;
import com.gl.entity.Citizen;
import com.gl.exception.CitizenException;
import com.gl.service.CitizenService;

@SpringBootApplication
public class DemoSpringDataApiApplication implements CommandLineRunner {

	@Autowired
	CitizenService service;
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringDataApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//this.getAllCitizen();
		//this.getCitizen();
		//this.addCitizenDetails();
		//this.updateDetails();
		this.removeCitizenDetails();
		
	}
	
	public void getAllCitizen()
	{
		List<CitizenDTO> citizens=service.getAllCitizen();
		for(CitizenDTO c:citizens)
			System.out.println(c);
	}
	public void getCitizen()
	{
		int id=1901;
		try 
		{
			CitizenDTO c=service.findCitizenDetails(id);
			System.out.println(c);
		} catch (CitizenException e) {
			System.out.println(e.getMessage());
		}
	}

	public void addCitizenDetails()
	{
		// initializes all instance_var to their respective default values
		CitizenDTO citizenDTO=new CitizenDTO(); 
		citizenDTO.setName("Bhumit ");
		citizenDTO.setAddress("Bhumit's Address");
		citizenDTO.setDob(LocalDate.of(1987, 11, 6));
		//citizenDTO.setEmailId("bhums@gmail.com");
		citizenDTO.setGender("Male");
		citizenDTO.setMobileNo("9835471736");
		
		citizenDTO=service.addCitizen(citizenDTO);
		System.out.println("You Details persisted successfully and Id is : "+citizenDTO.getId());
	}

	public void updateDetails()
	{
		int id=1010;
		
		CitizenDTO citizenDTO=new CitizenDTO();
		citizenDTO.setAddress("My New Address");
		citizenDTO.setMobileNo("9898989898");
		citizenDTO.setDob(LocalDate.of(2016, 03, 13));
		citizenDTO.setGender("Male");
		citizenDTO.setName("Bhumit");
		
		try
		{
			citizenDTO=service.updateCitizen(id, citizenDTO);
			System.out.println(citizenDTO);
		} catch (CitizenException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void removeCitizenDetails()
	{
		int id=1010;
		try {
			String message=service.removeCitizenDetails(id);
			System.out.println("Record "+message);
		} catch (CitizenException e) {
			System.out.println(e.getMessage());
		}
	}
}
