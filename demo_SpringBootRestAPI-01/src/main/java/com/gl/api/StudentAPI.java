package com.gl.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gl.dto.StudentDTO;
import com.gl.exception.StudentException;
import com.gl.service.StudentService;

@RestController
public class StudentAPI {
	
	@Autowired
	private StudentService service;
	
	// this is a method needed to be exposed as REST API URL= hostName+URI
	@GetMapping("/students")
	public List<StudentDTO> getAllStudent()
	{
		return service.getAllStudent();
	}
	
	
	@GetMapping("/students/{rollno}")
	public StudentDTO getStudentDetails(@PathVariable("rollno")Integer rollno)throws StudentException
	{
		return service.findStudent(rollno);
	}

	
	@PostMapping("/students")
	public StudentDTO addStudent(@RequestBody StudentDTO studentDTO)
	{
		return service.addStudent(studentDTO);
	}
	
	
	@PutMapping("/students/{rollno}")
	public StudentDTO updateStudentDetails(@PathVariable("rollno")Integer rollno,@RequestBody StudentDTO studentDTO)throws StudentException
	{
		return service.updateDetails(rollno, studentDTO);
	}
	
	@DeleteMapping("/students/{rollno}")
	public String removeStudentDetails(@PathVariable("rollno")Integer rollno) throws StudentException
	{
		return service.removeStudentDetails(rollno);
	}
	
	
	
	
	
	
	
}
