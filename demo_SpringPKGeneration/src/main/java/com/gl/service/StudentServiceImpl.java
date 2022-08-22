package com.gl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.dto.StudentDTO;
import com.gl.entity.Student;
import com.gl.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repository;
	@Override
	public List<StudentDTO> getAllStudent() {
		Iterable<Student> students=repository.findAll();
		List<StudentDTO> studentsDTO=new ArrayList<StudentDTO>();
		students.forEach((student)->{
			studentsDTO.add(this.getStudentDTO(student));
		});
		return studentsDTO;
	}

	@Override
	public StudentDTO addStudentDetails(StudentDTO s) {
		Student student=repository.save(this.getStudentEntity(s));
		return this.getStudentDTO(student);
	}
	
	public StudentDTO getStudentDTO(Student student)
	{
		StudentDTO s=new StudentDTO();
		s.setRollno(student.getRollno());
		s.setName(student.getName());
		s.setStream(student.getStream());
		
		return s;
		
	}
	
	public Student getStudentEntity(StudentDTO student)
	{
		Student s=new Student();
		s.setRollno(student.getRollno());
		s.setName(student.getName());
		s.setStream(student.getStream());
		return s;
	}

}
