package com.gl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.gl.dto.StudentDTO;

@SpringBootApplication
public class DemoSpringBootRestApiClientApplication implements CommandLineRunner{

	RestTemplate template=new RestTemplate();
	
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootRestApiClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//this.getStudent();
		//this.addStudent();
		//this.updateStudentDetails();
		//this.removeStudentDetails();
		this.getAllStudent();
		
	}
	
	public void getStudent(int rollno)
	{
		String apiURL="http://localhost:8080/students/{rollno}";
		Object obj=null;
		try 
		{
			obj=template.getForObject(apiURL, StudentDTO.class, rollno);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println(obj);
	}

	public void addStudent()
	{
		StudentDTO s=new StudentDTO();
		s.setName("Vivian");
		s.setStream("MBA");
		
		String apiURL="http://localhost:8080/students";
		s=template.postForObject(apiURL, s, StudentDTO.class);
		System.out.println("New Student details saved with Rollno : "+s.getRollno());
		
	}
	
	public void updateStudentDetails()
	{
		StudentDTO s=new StudentDTO();
		s.setRollno(106);
		s.setName("Vivian Mahajan");
		s.setStream("Master in Business Admin");
		String apiURL="http://localhost:8080/students/{rollno}";
		
		template.put(apiURL, s, s.getRollno());
		System.out.println("Updated ....");
		this.getStudent(s.getRollno());		
		
	}
	public void removeStudentDetails()
	{
		String apiURL="http://localhost:8080/students/{rollno}";
		template.delete(apiURL, 106);
		System.out.println("Deleted ...");
		this.getAllStudent();
		
	}
	
	public void getAllStudent()
	{
		String apiURL="http://localhost:8080/students";
		ResponseEntity<Object> students=template.getForEntity(apiURL,Object.class);
		System.out.println(students.getBody());
	}
}
