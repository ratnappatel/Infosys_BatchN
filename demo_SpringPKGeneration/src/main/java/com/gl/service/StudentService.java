package com.gl.service;

import java.util.List;

import com.gl.dto.StudentDTO;

public interface StudentService {

	public List<StudentDTO> getAllStudent();
	public StudentDTO addStudentDetails(StudentDTO s);
}
