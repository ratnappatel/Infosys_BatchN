package com.gl.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<StudentDTO>> getAllStudent()
	{
		List<StudentDTO> list=service.getAllStudent();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	
	@GetMapping("/students/{rollno}")
	public ResponseEntity<Object> getStudentDetails(@PathVariable("rollno")Integer rollno)
	{
	StudentDTO s=null;	
		try
		{
			s=service.findStudent(rollno);
		} catch (StudentException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(s,HttpStatus.OK);
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
