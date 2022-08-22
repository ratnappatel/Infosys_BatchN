package com.gl.dto;

import java.util.Objects;

public class StudentDTO {
	
	private int rollno;
	private String name;
	private String stream;
	private AddressDTO address;
	
	public StudentDTO() {
	}
	public StudentDTO(int rollno, String name, String stream,AddressDTO address) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.stream = stream;
		this.address=address;
	}
	
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
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
		return Objects.hash(address, name, rollno, stream);
	}
	@Override
	public boolean equals(Object obj) {
		
		StudentDTO other = (StudentDTO) obj;
		return Objects.equals(address, other.address) && Objects.equals(name, other.name) && rollno == other.rollno
				&& Objects.equals(stream, other.stream);
	}
	@Override
	public String toString() {
		return "StudentDTO [rollno=" + rollno + ", name=" + name + ", stream=" + stream + ", address=" + address + "]\n";
	}
	
	

}
