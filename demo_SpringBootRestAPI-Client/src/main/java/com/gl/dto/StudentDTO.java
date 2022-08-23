package com.gl.dto;

import java.util.Objects;

public class StudentDTO {
	private int rollno;
	private String name;
	private String stream;
	public StudentDTO() {
		// TODO Auto-generated constructor stub
	}
	public StudentDTO(int rollno, String name, String stream) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.stream = stream;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, rollno, stream);
	}
	@Override
	public boolean equals(Object obj) {
		
		StudentDTO other = (StudentDTO) obj;
		return Objects.equals(name, other.name) && rollno == other.rollno && Objects.equals(stream, other.stream);
	}
	@Override
	public String toString() {
		return "StudentDTO [rollno=" + rollno + ", name=" + name + ", stream=" + stream + "]\n";
	}
	

}
