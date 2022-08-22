package com.gl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gl.dto.StudentDTO;
import com.gl.entity.Student;
import com.gl.service.StudentService;

@SpringBootApplication
public class DemoSpringPkGenerationApplication implements CommandLineRunner{

	@Autowired
	private StudentService service;
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringPkGenerationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.addStudent();
		this.getAllStudent();
		
	}

	private void getAllStudent() {
		List<StudentDTO> students=service.getAllStudent();
		for(StudentDTO s:students)
			System.out.println(s);
		
	}

	private void addStudent() {
		StudentDTO studentDTO=new StudentDTO();
		studentDTO.setName("Uttam");
		studentDTO.setStream("Information Technology");
		
		studentDTO=service.addStudentDetails(studentDTO);
		System.out.println(studentDTO);
	}

}
