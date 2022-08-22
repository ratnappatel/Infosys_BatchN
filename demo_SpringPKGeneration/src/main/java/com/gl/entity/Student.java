package com.gl.entity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rollno;
	private String name;
	private String stream;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id",unique=true)
	private Address address;
	public Student() {
	}
	public Student(int rollno, String name, String stream, Address address) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.stream = stream;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, name, rollno, stream);
	}
	@Override
	public boolean equals(Object obj) {
		
		Student other = (Student) obj;
		return Objects.equals(address, other.address) && Objects.equals(name, other.name) && rollno == other.rollno
				&& Objects.equals(stream, other.stream);
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", stream=" + stream + ", address=" + address + "]";
	}
	

}
