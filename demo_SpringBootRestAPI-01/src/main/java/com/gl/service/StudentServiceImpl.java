package com.gl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.dto.StudentDTO;
import com.gl.entity.Student;
import com.gl.exception.StudentException;
import com.gl.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl  implements StudentService{
	
	@Autowired
	private StudentRepository repository;
	

	@Override
	public List<StudentDTO> getAllStudent() {
		Iterable<Student>  itr=repository.findAll();
		List<StudentDTO> students=new ArrayList<StudentDTO>(); 
		itr.forEach((student)->{
			students.add(this.getStudentDTO(student));
		});
		
		return students;
	}

	@Override
	public StudentDTO findStudent(int rollno)throws StudentException {
		Optional<Student> studentOptional=repository.findById(rollno);
		Student student=studentOptional.orElseThrow(()->new StudentException("Student with rollno "+rollno+" does not exists.."));
		
		return this.getStudentDTO(student);
	}

	@Override
	public StudentDTO updateDetails(int rollno, StudentDTO studentDTO) throws StudentException{
		Optional<Student> studentOptional=repository.findById(rollno);
		Student student=studentOptional.orElseThrow(()->new StudentException("Student with rollno "+rollno+" does not exists.."));
		student.setName(studentDTO.getName());
		student.setStream(studentDTO.getStream());
		
		student=repository.save(student);
		
		return this.getStudentDTO(student);
	}

	@Override
	public StudentDTO addStudent(StudentDTO studentDTO) {
		Student student=repository.save(this.getStudentEntity(studentDTO));
		return this.getStudentDTO(student);
	}

	@Override
	public String removeStudentDetails(int rollno)throws StudentException {
		Optional<Student> studentOptional=repository.findById(rollno);
		Student student=studentOptional.orElseThrow(()->new StudentException("Student with rollno "+rollno+" does not exists.."));
		repository.delete(student);
		return "Deleted....";
	}
	
	public StudentDTO getStudentDTO(Student student)
	{
		StudentDTO studentDTO=new StudentDTO();
		studentDTO.setRollno(student.getRollno());
		studentDTO.setName(student.getName());
		studentDTO.setStream(student.getStream());
		
		return studentDTO;
	}
	
	public Student getStudentEntity(StudentDTO studentDTO)
	{
		Student student=new Student();
		student.setRollno(studentDTO.getRollno());
		student.setName(studentDTO.getName());
		student.setStream(studentDTO.getStream());
		
		return student;
	}
	

}
