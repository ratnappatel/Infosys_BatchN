package com.gl.service;

import java.util.List;

import com.gl.dto.StudentDTO;
import com.gl.exception.StudentException;

public interface StudentService
{
	public List<StudentDTO> getAllStudent();
	public StudentDTO findStudent(int rollno) throws StudentException;
	public StudentDTO updateDetails(int rollno, StudentDTO studentDTO)throws StudentException;
	public StudentDTO addStudent(StudentDTO studentDTO);
	public String removeStudentDetails(int rollno)throws StudentException;
}
